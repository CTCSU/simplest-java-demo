package chentao.SimplestDemos.SimplestPOIExcelDemo;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class POIDemoTest {
    @Test
    public void testPOIDemo() throws IOException {
        POIDemo demo = new POIDemo();
        String filePath = demo.writeToExcel();
        System.out.println("---------------------------------------------------------");
        demo.readExcel(filePath);
    }
}