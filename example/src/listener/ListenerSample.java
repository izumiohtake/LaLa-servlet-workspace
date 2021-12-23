package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ListenerSample implements ServletContextListener {
	
    
    public ListenerSample() {
       
    }

    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	//アプリケーションスコープができた（サーブレットがない状態）
    	ServletContext context = sce.getServletContext();
    	Integer count = 0;
    	context.setAttribute("count", count);//保存
    	System.out.println("count:" + count + "をセット！");
    	
    }
	
}
