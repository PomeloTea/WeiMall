package data;

import java.sql.*;
import java.util.regex.*;
import javax.persistence.Entity;
import hibernate.*;

@Entity
public class Database {
	public static int checkseller(String username,String pwd){
		int ret = -1;
		System.out.println("checkUser");
		//ret=-2用户不存在
		//ret=-1密码错误
		//ret>=0登陆成功，返回用户ID
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/weimall";
			String user = "root";
			String password = "";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			CallableStatement cs =conn.prepareCall("call checkseller(?,?,?)");
			cs.setString(1, username);
			cs.setString(2, pwd);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.execute();
			ret = cs.getInt(3);
			cs.close();  
			conn.close();
		}
		catch(Exception e){}; 
		System.out.println(ret);
		return ret;
	}
	
	public static int regseller(String username,String email,String pwd){
		int ret = -1;
		System.out.println("regUser");
		//ret=-2用户名已存在
		//ret=-1邮箱已存在
		//ret>=0注册成功，返回用户ID
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/weimall";
			String user = "root";
			String password = "";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			CallableStatement cs =conn.prepareCall("call regseller(?,?,?,?)");
			cs.setString(1, username);
			cs.setString(2, email);
			cs.setString(3, pwd);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.execute();
			ret = cs.getInt(4);
			cs.close();  
			conn.close();
		}
		catch(Exception e){}; 
		System.out.println(ret);
		return ret;
	}
	
	public static int saveSellerInfo(int SellerId,String Realname,int Sex,String Birthday,String Qq,String Phone)
	{
		//ret = 0 信息储存成功
		//ret = 1  真实姓名长度错误
		//ret = 2 qq不符合规范
		//ret = 3 手机号不符合规范
		//ret = 4 卖家不存在
		int ret=0;
		System.out.println("saveSellerInfo");
		String regEx;
		Pattern p;
		Matcher m;
		//check Realname
		regEx = ".{1,20}";
		p = Pattern.compile(regEx);
		m = p.matcher(Realname);
		if (!m.matches() && !Realname.equals("")) ret = 1;
		else
		{
			//check Qq
			regEx = "[1-9][0-9]{4,}";
			p = Pattern.compile(regEx);
			m = p.matcher(Qq);
			if (!m.matches() && !Qq.equals("")) ret = 2;
			else
			{
				//check phone
				regEx = "\\+?(86)?[0-9]{11}";
				p = Pattern.compile(regEx);
				m = p.matcher(Phone);
				if (!m.matches() && !Phone.equals("")) ret = 3;
			}
		}
		SellerDAO sellerDao = new SellerDAO();
		Seller seller = sellerDao.findById(SellerId);
		if (seller == null) ret=4;
		else if(ret == 0){
			seller.setSellerRealName(Realname);
			seller.setSellerSex(Sex);
			seller.setSellerBirthday(Birthday);
			seller.setSellerQq(Qq);
			seller.setSellerPhoneNum(Phone);
			sellerDao.save(seller);
		}
		System.out.println(ret);
		return ret;
	}	
	
	public static int setLoginTime(int SellerId,String LoginTime)
	{
		//ret=0 卖家不存在
		//ret=1保存成功
		System.out.println("setLoginTime");
		//System.out.println(SellerId);
		//System.out.println(LoginTime);
		int ret;
		SellerDAO sellerDao = new SellerDAO();
		Seller seller = sellerDao.findById(SellerId);
		if (seller == null) ret=0;
		else{
			//System.out.println(LoginTime);
			seller.setSellerLastLoginTime(LoginTime);
			sellerDao.save(seller);
			ret = 1;
		}
		System.out.println("ret:" + ret);
		return ret;
	}

	public static String getLoginTime(int SellerId)
	{
		//ret=null 卖家不存在
		System.out.println("getLoginTime");
		String ret;
		SellerDAO sellerDao = new SellerDAO();
		Seller seller = sellerDao.findById(SellerId);
		if (seller == null) ret=null;
		else ret = seller.getSellerLastLoginTime();
		System.out.println(ret);
		return ret;
	}
	
	public static int setPwd(int SellerId,String Pwd)
	{
		//ret=0 买家不存在
		System.out.println("getLoginTime");
		int ret;
		SellerDAO sellerDao = new SellerDAO();
		Seller seller = sellerDao.findById(SellerId);
		if (seller == null) ret=0;
		else{
			ret = 1;
			seller.setSellerPwd(Pwd);
			sellerDao.save(seller);
		}
		System.out.println(ret);
		return ret;
	}
	
	public static void main(String[] args){ 
		saveSellerInfo(0,"你好",1,"19930527","304144421","+8615601717257");
		setLoginTime(0, "Sat Mar 01 2014 00:56:57 GMT+0800 (CST)");
	}
}
