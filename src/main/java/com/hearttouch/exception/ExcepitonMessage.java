package com.hearttouch.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
* <p>Title: ExcepitonMessage.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2015<／p>
* <p>Company: xincd<／p>
* @author Yeah
* @date 2015年6月27日
* @version 1.0
*/
public class ExcepitonMessage extends PrintWriter{  
	  
    public ExcepitonMessage(){  
        super(new StringWriter());  
    }  
     
    public String getString() {  
          flush();  
          return ((StringWriter) this.out).toString();  
    }  
     
    @Override  
    public String toString() {  
        return getString();  
    }  
}
