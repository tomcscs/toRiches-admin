package model.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * 데이터 처리를 하기 위해서 만든 객체를 DAO / Repository 라고 부른다.  
 * Data Access Object 의 약자
 */

public class ItemProcessor {
	// 1. DATA SAVE
	public boolean save(Item one) throws ClassNotFoundException {
		boolean result = false;
		// 1. 데이터 베이스 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@3.34.136.55:1521:xe", "toRich",
				"oracle")) {
			// 2. 필요한 작업요청을 전송하고 응답을 받으면 됨.
			String sql = String.format("INSERT INTO ITEMS VALUES(%d,'%s', %d, %f, %f)", one.getCode(), one.getName(),
					one.getPrice(), one.getMinRate(), one.getMaxRate());

			System.out.println("SQL = " + sql);
			PreparedStatement pstmst = conn.prepareStatement(sql);
			int n = pstmst.executeUpdate(); // 요청 전송하고 DB에서 응답을 받아옴.
			if (n == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 3. DATA FIND BY KEY
	public Item findByKey(int key) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@3.34.136.55:1521:xe", "toRich",
				"oracle")) {

			String sql = "SELECT * FROM ITEMS WHERE CODE=" + key;
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int code = rs.getInt(1); // rs.getInt("code")
				String name = rs.getString(2); // rs.getString("name");
				int price = rs.getInt(3); // rs.getInt("price");
				double minRate = rs.getDouble(4); // rs.getDouble("min_rate");
				double maxRate = rs.getDouble(5); // rs.getDouble("max_rate");

				return new Item(code, name, price, minRate, maxRate);
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// 2. DATA FIND ALL
	public List<Item> findAll() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@3.34.136.55:1521:xe", "toRich",
				"oracle")) {
			String sql = "SELECT * FROM ITEMS ORDER BY PRICE DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			List<Item> list = new ArrayList<>();
			while (rs.next()) {
				int code = rs.getInt(1); // rs.getInt("code")
				String name = rs.getString(2); // rs.getString("name");
				int price = rs.getInt(3); // rs.getInt("price");
				double minRate = rs.getDouble(4); // rs.getDouble("min_rate");
				double maxRate = rs.getDouble(5); // rs.getDouble("max_rate");

				Item one = new Item(code, name, price, minRate, maxRate);
				list.add(one);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// 3. DATA UPDATE ONE
	public boolean update(Item one) throws ClassNotFoundException {
		boolean result = false;
		// 0. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@3.34.136.55:1521:xe", "torich",
				"oracle")) {
			String sql = "UPDATE ITEMS SET  MIN_RATE=?, MAX_RATE=?, PRICE=?, NAME=? WHERE CODE=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, one.getMinRate());
			pstmt.setDouble(2, one.getMaxRate());
			pstmt.setInt(3, one.getPrice());
			pstmt.setString(4, one.getName());
			pstmt.setInt(5, one.getCode());
			
			int r = pstmt.executeUpdate();
			
			if(r == 1) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
