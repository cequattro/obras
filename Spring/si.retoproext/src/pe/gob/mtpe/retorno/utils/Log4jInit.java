package pe.gob.mtpe.retorno.utils;

import javax.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet{
    
	private static final long serialVersionUID = 1L;

	public void init(){
      String prefix_dir   = getServletContext().getRealPath("/");
      String param_file   = getInitParameter("log4j-init-file");
      PropertyConfigurator.configure(prefix_dir + param_file);
    }

}
