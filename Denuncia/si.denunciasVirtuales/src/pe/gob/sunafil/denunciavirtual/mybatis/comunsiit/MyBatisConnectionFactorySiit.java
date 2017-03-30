package pe.gob.sunafil.denunciavirtual.mybatis.comunsiit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactorySiit {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "pe/gob/sunafil/denunciavirtual/mybatis/configsiit/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		}
		catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
