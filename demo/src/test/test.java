package test;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import po.User;

public class test{
	//会话工厂
		private static SqlSessionFactory sqlSessionFactory;

		@Before
		public void createSqlSessionFactory() throws IOException {
			// 配置文件
			String resource = "SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		}

		// 根据 id查询用户信息
	
		public static void main(String[] args) throws IOException {
			// 配置文件
						String resource = "SqlMapConfig.xml";
						InputStream inputStream = Resources.getResourceAsStream(resource);

						// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 数据库会话实例
			SqlSession sqlSession = null;
			try {
				// 创建数据库会话实例sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// 查询单个记录，根据用户id查询用户信息
				User user = sqlSession.selectOne("test.findUserById", 10);
				// 输出用户信息
				System.out.println(user);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}

		}
		// 根据用户名称模糊查询用户信息
		@Test
		public void testFindUserByUsername() {
			// 数据库会话实例
			SqlSession sqlSession = null;
			try {
				// 创建数据库会话实例sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// 查询单个记录，根据用户id查询用户信息
				List<User> list = sqlSession.selectList("test.findUserByUsername", "小明");
				System.out.println(list.size());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}

		}
		// 添加用户信息
		@Test
		public void testInsert() {
			// 数据库会话实例
			SqlSession sqlSession = null;
			try {
				// 创建数据库会话实例sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// 添加用户信息
				User user = new User();
				user.setUsername("张小明");
				user.setAddress("河南郑州");
				user.setSex("1");
				Date ss = new Date();
			String s ="1991-12-30";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(s);

				
				user.setBirthday(date);
				sqlSession.insert("test.insertUser", user);
				//提交事务
				sqlSession.commit();
				System.out.println(user.getId());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}
		}
		@Test
		public void testDelete() {
			// 数据库会话实例
			SqlSession sqlSession = null;
			try {
				// 创建数据库会话实例sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// 删除用户
				sqlSession.delete("test.deleteUserById",40);
				// 提交事务
				sqlSession.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}
		}




}
