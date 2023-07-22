/**
 * 
 */
package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import com.itextpdf.text.List;

import dbconnection.Dbconnection;
import vo.CustomerVO;
import vo.HomeVO;
import vo.InvoiceVO;
import vo.ProductVO;
import vo.ResultVO;
import vo.UserVO;

/**
 * @author Rupayan Dirghangi
 *
 */
public class DaoImpl {
	public Connection con = null;
	public PreparedStatement ps = null;
	public PreparedStatement ps1 = null;
	public PreparedStatement ps2 = null;
	public PreparedStatement ps3 = null;
	Dbconnection dc = new Dbconnection();
	ResultVO rvo = new ResultVO();
	HomeVO hvo = new HomeVO();
	boolean status = false;

	/**
	 * @param args
	 */
	public ResultVO dataInsert(UserVO uvo) {
		try {
			String username = uvo.getUsername();
			String password = uvo.getPassword();

			con = dc.dbconnect();

			String insertQuery = "insert into registration values(DEFAULT, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, username);
			ps.setString(2, password);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}

	public int passwordUpdate(UserVO uvo) {
		try {
			String username = uvo.getUsername();
			String password = uvo.getPassword();

			con = dc.dbconnect();

			String updateQuery = "update registration set password=? where username=?";
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, password);
			ps.setString(2, username);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data Updated");
			} else {
				System.out.println("Failed");
			}
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}

	public String Login(UserVO uvo) {
		try {

			String username = uvo.getUsername();
			String password = uvo.getPassword();

			con = dc.dbconnect();

			String loginQuery = "select * from registration where username=? and password=?";
			ps = con.prepareStatement(loginQuery);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status) {
				return "true";
			} else {
				return "false";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

//	Customer details
	public ResultVO customerInsert(CustomerVO cvo) {
		try {
			String fname = cvo.getFirstname();
			String lname = cvo.getLastname();
			String email = cvo.getEmail();
			String phone = cvo.getPhone();
			String address = cvo.getAddress();
			String country = cvo.getCountry();

			con = dc.dbconnect();

			String insertQuery = "insert into customer values(DEFAULT, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.setString(6, country);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}
	public List<CustomerVO> customerLists(){
		List<CustomerVO> list=new ArrayList<>();
		
		try {
			con = dc.dbconnect();
			String customerSelect = "select * from customer";
			ps = con.prepareStatement(customerSelect);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CustomerVO cvo=new CustomerVO();
				cvo.setId(rs.getInt("id"));
				cvo.setFirstname(rs.getString("fname"));
				cvo.setLastname(rs.getString("lname"));
				cvo.setEmail(rs.getString("email"));
				cvo.setPhone(rs.getString("phone"));
				cvo.setAddress(rs.getString("address"));
				cvo.setCountry(rs.getString("country"));
				
				list.add(cvo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public CustomerVO getCustomerById(int id) {
		CustomerVO cvo=null;
		try {
			con = dc.dbconnect();
			String customerSelectById = "select * from customer where id=?";
			ps = con.prepareStatement(customerSelectById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cvo=new CustomerVO();
				cvo.setId(rs.getInt("id"));
				cvo.setFirstname(rs.getString("fname"));
				cvo.setLastname(rs.getString("lname"));
				cvo.setEmail(rs.getString("email"));
				cvo.setPhone(rs.getString("phone"));
				cvo.setAddress(rs.getString("address"));
				cvo.setCountry(rs.getString("country"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cvo;
	}

	public ResultVO customerUpdate(CustomerVO cvo) {
		try {
			String fname = cvo.getFirstname();
			String lname = cvo.getLastname();
			String email = cvo.getEmail();
			String phone = cvo.getPhone();
			String address = cvo.getAddress();
			String country = cvo.getCountry();
			int id = cvo.getId();

			con = dc.dbconnect();

			String updateQuery = "update customer set fname=?,lname=?,email=?,phone=?,address=?,country=? where id=?";
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.setString(6, country);
			ps.setInt(7, id);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data Updated");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}

	public ResultVO customerDelete(CustomerVO cvo) {
		try {
			int id = cvo.getId();

			con = dc.dbconnect();

			String deleteQuery = "delete from customer where id=?";
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data Deleted");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}

//	Product details
	public ResultVO productInsert(ProductVO pvo) {
		try {
			String pname = pvo.getProductname();
			String price = pvo.getPrice();
			String pdescription = pvo.getPdescription();

			con = dc.dbconnect();

			String insertQuery = "insert into product values(DEFAULT, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, pname);
			ps.setString(2, price);
			ps.setString(3, pdescription);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}
	
	public List<ProductVO> productLists(){
		List<ProductVO> list=new ArrayList<>();
		
		try {
			con = dc.dbconnect();
			String customerSelect = "select * from product";
			ps = con.prepareStatement(customerSelect);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO pvo=new ProductVO();
				pvo.setId(rs.getInt("id"));
				pvo.setProductname(rs.getString("pname"));
				pvo.setPrice(rs.getString("price"));
				pvo.setPdescription(rs.getString("pdescription"));
				
				list.add(pvo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ProductVO getProductById(int id) {
		ProductVO pvo=null;
		try {
			con = dc.dbconnect();
			String productSelectById = "select * from product where id=?";
			ps = con.prepareStatement(productSelectById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pvo=new ProductVO();
				pvo.setId(rs.getInt("id"));
				pvo.setProductname(rs.getString("pname"));
				pvo.setPrice(rs.getString("price"));
				pvo.setPdescription(rs.getString("pdescription"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return pvo;
	}

	public ResultVO productUpdate(ProductVO pvo) {
		try {
			String pname = pvo.getProductname();
			String price = pvo.getPrice();
			String pdescription = pvo.getPdescription();
			int id = pvo.getId();

			con = dc.dbconnect();

			String updateQuery = "update product set pname=?,price=?,pdescription=? where id=?";
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, pname);
			ps.setString(2, price);
			ps.setString(3, pdescription);
			ps.setInt(4, id);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data Updated");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}

	public ResultVO productDelete(ProductVO pvo) {
		try {
			int id = pvo.getId();

			con = dc.dbconnect();

			String deleteQuery = "delete from product where id=?";
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data Deleted");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}

	// Invoice Section
	public ResultVO invoiceInsert(InvoiceVO ivo) {
		try {
			String invoiceDate = ivo.getInvoiceDate();
			String dueDate = ivo.getDueDate();
			String invoiceNo = ivo.getInvoiceNo();
			String invoiceStatus = ivo.getInvoiceStatus();
			String product = ivo.getProduct();
			String customer = ivo.getCustomer();
			String quantity = ivo.getQuantity();
			String price = ivo.getPrice();
			String discount = ivo.getDiscount();
			String shippingCost = ivo.getShippingCost();

			con = dc.dbconnect();

			String insertQuery = "insert into invoice values(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, invoiceDate);
			ps.setString(2, dueDate);
			ps.setString(3, invoiceNo);
			ps.setString(4, invoiceStatus);
			ps.setString(5, product);
			ps.setString(6, customer);
			ps.setString(7, quantity);
			ps.setString(8, price);
			ps.setString(9, discount);
			ps.setString(10, shippingCost);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}
	
	public List<InvoiceVO> invoiceLists(){
		List<InvoiceVO> list=new ArrayList<>();
		
		try {
			con = dc.dbconnect();
			String invoiceSelect = "select * from invoice";
			ps = con.prepareStatement(invoiceSelect);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				InvoiceVO ivo=new InvoiceVO();
				ivo.setId(rs.getInt("id"));
				ivo.setInvoiceDate(rs.getString("invoiceDate"));
				ivo.setDueDate(rs.getString("dueDate"));
				ivo.setInvoiceNo(rs.getString("invoiceNo"));
				ivo.setInvoiceStatus(rs.getString("invoiceStatus"));
				ivo.setProduct(rs.getString("product"));
				ivo.setCustomer(rs.getString("customer"));
				ivo.setQuantity(rs.getString("quantity"));
				ivo.setPrice(rs.getString("price"));
				ivo.setDiscount(rs.getString("discount"));
				ivo.setShippingCost(rs.getString("shippingCost"));
				
				list.add(ivo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public InvoiceVO getInvoiceById(int id) {
		InvoiceVO ivo=null;
		try {
			con = dc.dbconnect();
			String invoiceSelectById = "select * from invoice where id=?";
			ps = con.prepareStatement(invoiceSelectById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ivo=new InvoiceVO();
				ivo.setId(rs.getInt("id"));
				ivo.setInvoiceDate(rs.getString("invoiceDate"));
				ivo.setDueDate(rs.getString("dueDate"));
				ivo.setInvoiceNo(rs.getString("invoiceNo"));
				ivo.setInvoiceStatus(rs.getString("invoiceStatus"));
				ivo.setProduct(rs.getString("product"));
				ivo.setCustomer(rs.getString("customer"));
				ivo.setQuantity(rs.getString("quantity"));
				ivo.setPrice(rs.getString("price"));
				ivo.setDiscount(rs.getString("discount"));
				ivo.setShippingCost(rs.getString("shippingCost"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ivo;
	}

	public ResultVO invoiceUpdate(InvoiceVO ivo) {
		try {
			String invoiceDate = ivo.getInvoiceDate();
			String dueDate = ivo.getDueDate();
			String invoiceNo = ivo.getInvoiceNo();
			String invoiceStatus = ivo.getInvoiceStatus();
			String product = ivo.getProduct();
			String customer = ivo.getCustomer();
			String quantity = ivo.getQuantity();
			String price = ivo.getPrice();
			String discount = ivo.getDiscount();
			String shippingCost = ivo.getShippingCost();
			int id = ivo.getId();

			con = dc.dbconnect();

			String updateQuery = "update invoice set invoiceDate=?,dueDate=?,invoiceNo=?,invoiceStatus=?,product=?,customer=?,quantity=?,price=?,discount=?,shippingCost=? where id=?";
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, invoiceDate);
			ps.setString(2, dueDate);
			ps.setString(3, invoiceNo);
			ps.setString(4, invoiceStatus);
			ps.setString(5, product);
			ps.setString(6, customer);
			ps.setString(7, quantity);
			ps.setString(8, price);
			ps.setString(9, discount);
			ps.setString(10, shippingCost);
			ps.setInt(11, id);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data Updated");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}

	public ResultVO invoiceDelete(InvoiceVO ivo) {
		try {
			int id = ivo.getId();

			con = dc.dbconnect();

			String deleteQuery = "delete from invoice where id=?";
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data Deleted");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}

	// Home page
	public HomeVO showStat() {
		try {

			con = dc.dbconnect();

			String invoiceQuery = "select count(*) from invoice";
			String customerQuery = "select count(*) from customer";
			String productQuery = "select count(*) from product";
			String userQuery = "select count(*) from registration";
			ps = con.prepareStatement(invoiceQuery);
			ResultSet rs1 = ps.executeQuery();
			rs1.next();
			hvo.setIvn(rs1.getInt(1));

			ps1 = con.prepareStatement(customerQuery);
			ResultSet rs2 = ps1.executeQuery();
			rs2.next();
			hvo.setCun(rs2.getInt(1));

			ps2 = con.prepareStatement(productQuery);
			ResultSet rs3 = ps2.executeQuery();
			rs3.next();
			hvo.setPrn(rs3.getInt(1));

			ps3 = con.prepareStatement(userQuery);
			ResultSet rs4 = ps3.executeQuery();
			rs4.next();
			hvo.setUsn(rs4.getInt(1));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return hvo;

	}
}
