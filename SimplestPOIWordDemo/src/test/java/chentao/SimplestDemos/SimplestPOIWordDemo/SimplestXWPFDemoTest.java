package chentao.SimplestDemos.SimplestPOIWordDemo;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SimplestXWPFDemoTest {

    @Test
    public void writeToDocxDocument() throws IOException {
        SimplestXWPFDemo demo = new SimplestXWPFDemo();
        String filePath = demo.writeToDocxDocument();
        String result = demo.readFromWordDocument(filePath);
        System.out.println(result);
    }
}