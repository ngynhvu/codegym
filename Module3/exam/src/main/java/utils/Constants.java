package utils;

public interface Constants {
    String SELECT_ALL_PRODUCT = "select product_id, pro.name, price, quantity,color, description, ct.name_category from product pro join category ct on pro.category_id = ct.category_id;";
    String INSERT_INTO_PRODUCT = "insert into product values(?,?,?,?,?,?,?)";
    String UPDATE_PRODUCT = "update product set name = ?, price = ?, quantity = ?, color=?,description=?, category_id =? where product_id = ?";
    String FIND_CUSTOMER_BY_ID = "";
    String DELETE_PRODUCT_SQL = "delete from product where product_id = ?;";
    String SELECT_ALL_CATEGORY = "select * from category";
}
