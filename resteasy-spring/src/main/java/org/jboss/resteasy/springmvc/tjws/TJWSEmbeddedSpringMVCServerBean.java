package org.jboss.resteasy.springmvc.tjws;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class TJWSEmbeddedSpringMVCServerBean implements InitializingBean,
      DisposableBean, FactoryBean
{
   private String applicationContextConfiguration;
   private int port;
   private String context = ""; 

   private TJWSEmbeddedSpringMVCServer server;

   public String getApplicationContextConfiguration()
   {
      return applicationContextConfiguration;
   }

   public void setApplicationContextConfiguration(
         String applicationContextConfiguration)
   {
      this.applicationContextConfiguration = applicationContextConfiguration;
   }

   public int getPort()
   {
      return port;
   }

   public void setPort(int port)
   {
      this.port = port;
   }

   public TJWSEmbeddedSpringMVCServer getServer()
   {
      return server;
   }

   public void setServer(TJWSEmbeddedSpringMVCServer server)
   {
      this.server = server;
   }

   public String getContext()
   {
      return context;
   }

   public void setContext(String context)
   {
      this.context = context;
   }

   public void afterPropertiesSet() throws Exception
   {
      server = new TJWSEmbeddedSpringMVCServer(
            this.applicationContextConfiguration, this.port, context);
      server.start();
   }

   public void destroy() throws Exception
   {
      server.stop();
      server = null;
   }

   public Object getObject() throws Exception
   {
      return server;
   }

   public Class getObjectType()
   {
      return TJWSEmbeddedSpringMVCServer.class;
   }

   public boolean isSingleton()
   {
      return true;
   }

}
