import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product extends Connect {
    private Integer id;
    private String name;
    private Integer price;
    private Integer honoraryCode;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        System.out.println("Введите id товара для изменения состояния с {in_stock} в {for_sale}");
        return sc.nextInt();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getHonoraryCode() {
        return honoraryCode;
    }

    public void setHonoraryCode(Integer honoraryCode) {
        this.honoraryCode = honoraryCode;
    }

    public void startSale(Product product) {
        String changesState = "update auction.products set state = 'for_sale' where id = ? and state like 'in_stock'";
        try (PreparedStatement preparedStatement = connection().prepareStatement(changesState)) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        System.out.println("Успешное начало торгов");
    }

    public void raisePrice(Product product) {

        if (product.state.equals("IN_STOCK") || product.state.equals("SOLD")) {
            try {
                throw new NotAtAuction("Товар не учавствует в торгах!");
            } catch (NotAtAuction e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void withdraw(Product product) {

    }

    public void giveToTheWinner(Product product) {

    }

    @Override
    public String toString() {
        return "ID: " + this.id + " \n" +
                "NAME: " + this.name + " \n" +
                "PRICE: " + this.price + " \n" +
                "HONORARY_CODE: " + this.honoraryCode + " \n" +
                "STATE: " + this.state;
    }
}
