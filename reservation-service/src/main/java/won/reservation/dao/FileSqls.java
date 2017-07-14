package won.reservation.dao;

public class FileSqls {
	static final String SELECT_BY_PRODUCT_ID = "select f.id id, f.user_id user_id, f.file_name file_name, f.save_file_name save_file_name, "
			+ "f.file_length file_length, f.content_type content_type, f.delete_flag delete_flag, f.create_date create_date, f.modify_date modify_date " + 
			"from product p, product_image pi, file f " + 
			"where pi.product_id = p.id and f.id = pi.file_id and pi.product_id = :productid " + 
			"order by pi.type asc";
}
