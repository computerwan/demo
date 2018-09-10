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
	//�Ự����
		private static SqlSessionFactory sqlSessionFactory;

		@Before
		public void createSqlSessionFactory() throws IOException {
			// �����ļ�
			String resource = "SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// ʹ��SqlSessionFactoryBuilder��xml�����ļ��д���SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		}

		// ���� id��ѯ�û���Ϣ
	
		public static void main(String[] args) throws IOException {
			// �����ļ�
						String resource = "SqlMapConfig.xml";
						InputStream inputStream = Resources.getResourceAsStream(resource);

						// ʹ��SqlSessionFactoryBuilder��xml�����ļ��д���SqlSessionFactory
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// ���ݿ�Ựʵ��
			SqlSession sqlSession = null;
			try {
				// �������ݿ�Ựʵ��sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// ��ѯ������¼�������û�id��ѯ�û���Ϣ
				User user = sqlSession.selectOne("test.findUserById", 10);
				// ����û���Ϣ
				System.out.println(user);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}

		}
		// �����û�����ģ����ѯ�û���Ϣ
		@Test
		public void testFindUserByUsername() {
			// ���ݿ�Ựʵ��
			SqlSession sqlSession = null;
			try {
				// �������ݿ�Ựʵ��sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// ��ѯ������¼�������û�id��ѯ�û���Ϣ
				List<User> list = sqlSession.selectList("test.findUserByUsername", "С��");
				System.out.println(list.size());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}

		}
		// ����û���Ϣ
		@Test
		public void testInsert() {
			// ���ݿ�Ựʵ��
			SqlSession sqlSession = null;
			try {
				// �������ݿ�Ựʵ��sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// ����û���Ϣ
				User user = new User();
				user.setUsername("��С��");
				user.setAddress("����֣��");
				user.setSex("1");
				Date ss = new Date();
			String s ="1991-12-30";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(s);

				
				user.setBirthday(date);
				sqlSession.insert("test.insertUser", user);
				//�ύ����
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
			// ���ݿ�Ựʵ��
			SqlSession sqlSession = null;
			try {
				// �������ݿ�Ựʵ��sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// ɾ���û�
				sqlSession.delete("test.deleteUserById",40);
				// �ύ����
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
