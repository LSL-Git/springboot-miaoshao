package com.fq.util;


import com.fq.entify.MiaoshaUser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserUtil {
	
	private static void createUser(int count) throws Exception{
		List<MiaoshaUser> users = new ArrayList<MiaoshaUser>(count);
		//生成用户
		System.out.println(count);
		for(int i=0;i<count;i++) {
			System.out.println(i);
			MiaoshaUser user = new MiaoshaUser();
			user.setId(13000000000L+i);
			user.setLoginCount(1);
			user.setNickname("user"+i);
			user.setRegisterDate(new Date());
			user.setSalt("1a2b3ckjhgvhythnv");
			user.setPassword(Md5Util.formPassToDB("003d3d09d0236e398bbbf5027e9ab3f7", user.getSalt()));
			users.add(user);
		}
		System.out.println("create user");
//		//插入数据库
//		Connection conn = DBUtil.getConn();
//		String sql = "insert into miasha_user(loginCount, nickname, registerDate, salt, password, id)values(?,?,?,?,?,?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		for(int i=0;i<users.size();i++) {
//			MiaoshaUser user = users.get(i);
//			pstmt.setInt(1, user.getLoginCount());
//			pstmt.setString(2, user.getNickname());
//			pstmt.setTimestamp(3, new Timestamp(user.getRegisterDate().getTime()));
//			pstmt.setString(4, user.getSalt());
//			pstmt.setString(5, user.getPassword());
//			pstmt.setLong(6, user.getId());
//			pstmt.addBatch();
//		}
//		pstmt.executeBatch();
//		pstmt.close();
//		conn.close();
//		System.out.println("insert to db");

	//登录，生成token
	//String urlString = "http://localhost:8080/login/do_login";
//	File file = new File("D:/tokens.txt");
//		if(file.exists()) {
//		file.delete();
//	}
//	RandomAccessFile raf = new RandomAccessFile(file, "rw");
//		file.createNewFile();
//		raf.seek(0);
//		for(int i=0;i<users.size();i++) {
//		MiaoshaUser user = users.get(i);
//		URL url = new URL(urlString);
//		HttpURLConnection co = (HttpURLConnection)url.openConnection();
//		co.setRequestMethod("POST");
//		co.setDoOutput(true);
//		OutputStream out = co.getOutputStream();
//		String params = "mobile="+user.getId()+"&password="+Md5Util.inputassToForm("123456");
//		out.write(params.getBytes());
//		out.flush();
//		InputStream inputStream = co.getInputStream();
//		ByteArrayOutputStream bout = new ByteArrayOutputStream();
//		byte buff[] = new byte[1024];
//		int len = 0;
//		while((len = inputStream.read(buff)) >= 0) {
//			bout.write(buff, 0 ,len);
//		}
//		inputStream.close();
//		bout.close();
//		String response = new String(bout.toByteArray());
//		JSONObject jo = JSON.parseObject(response);
//		String token = jo.getString("data");
//		System.out.println("create token : " + user.getId());
//
//		String row = user.getId()+","+token;
//		raf.seek(raf.length());
//		raf.write(row.getBytes());
//		raf.write("\r\n".getBytes());
//		System.out.println("write to file : " + user.getId());
//	}
//		raf.close();
//
//		System.out.println("over");

		//BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D://tokens.txt"));
		BufferedWriter buffered = new BufferedWriter(new FileWriter("D://tokens.txt"));
		for (int j = 0; j<count; j++){
			MiaoshaUser user = users.get(j);
			String s = user.getId() + "," +"003d3d09d0236e398bbbf5027e9ab3f7";
			buffered.write(s);
			buffered.newLine();
		}
		buffered.close();

	}
	public static void main(String[] args)throws Exception {
		createUser(5000);
	}
}
