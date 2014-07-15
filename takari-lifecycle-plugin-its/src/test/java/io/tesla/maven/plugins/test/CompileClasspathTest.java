package io.tesla.maven.plugins.test;

import io.takari.maven.testing.it.VerifierResult;

import java.io.File;

import org.junit.Test;

public class CompileClasspathTest extends AbstractIntegrationTest {

  public CompileClasspathTest(String mavenVersion) throws Exception {
    super(mavenVersion);
  }

  @Test
  public void testClasspath() throws Exception {
    File basedir = resources.getBasedir("compile-classpath");

    VerifierResult result = verifier.forProject(basedir).execute("compile");
    result.assertErrorFreeLog();
    result.assertLogText("takari-lifecycle-plugin:" + properties.getPluginVersion() + ":compile");
    // TODO assert the class file(s) were actually created
  }
}
