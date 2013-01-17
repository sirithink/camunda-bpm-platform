package org.camunda.bpm.engine.rest;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.activiti.engine.ProcessEngine;
import org.apache.cxf.endpoint.Server;
import org.camunda.bpm.engine.rest.spi.ProcessEngineProvider;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public abstract class AbstractRestServiceTest {
  
  protected static ProcessEngine processEngine;
  protected static Server server;
  
  @BeforeClass
  public static void initialize() {
    
    loadProcessEngineService();
  }
  
  private static void loadProcessEngineService() {
    ServiceLoader<ProcessEngineProvider> serviceLoader = ServiceLoader.load(ProcessEngineProvider.class);
    Iterator<ProcessEngineProvider> iterator = serviceLoader.iterator();
    
    if(iterator.hasNext()) {
      ProcessEngineProvider provider = iterator.next();
      processEngine = provider.getProcessEngine();      
    }
  }
  
  @Deployment(testable = true)
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class, "test.jar")
        .addPackages(true, "org.camunda.bpm.engine.rest")
        .addAsResource("META-INF/services/org.camunda.bpm.engine.rest.spi.ProcessEngineProvider");
  }
  
}