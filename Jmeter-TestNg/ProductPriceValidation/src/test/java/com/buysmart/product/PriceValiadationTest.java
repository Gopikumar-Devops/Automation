package com.buysmart.product;

import com.buysmart.home.Base;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class PriceValiadationTest extends Base {

    @BeforeClass
    public void testSetUp() {
        PageFactory.initElements(driver, launchBrowser());
    }


    @Test
    public void pricevalidation() throws IOException {

        FileReader filereader = new FileReader("datafiles/ProductPrices_URLs.csv");
        try {
            File file = new File("datafiles/Validated_ProductPrices_URLs.csv");
            if (file.exists()) {
                file.delete();

                }
        } catch (Exception e) {
        }
        FileWriter filewriter = new FileWriter("datafiles/Validated_ProductPrices_URLs.csv", true);

        filewriter.append("url");
        filewriter.append(",");
        filewriter.append("MRP");
        filewriter.append(",");
        filewriter.append("Price");
        filewriter.append(",");
        filewriter.append("Expected MRP");
        filewriter.append(",");
        filewriter.append("Expected Price");
        filewriter.append("\n");

        CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
        List<String[]> allRows = csvReader.readAll();
        String[] record;
        String value0 ="";
        String mrp, price;
        for (String[] row : allRows) {
            try {
                record = Arrays.toString(row).split(",");
                value0 = record[0].replace("[", "").replace("]", "").replace(" ", "").toString();
                String value1 = record[1].replace("[", "").replace("]", "").replace(" ", "").toString();
                String value2 = record[2].replace("[", "").replace("]", "").replace(" ", "").toString();

                if (value0.contains("amazon")) {
                    driver.get(value0);
                    Thread.sleep(2000);
                    try {
                        mrp = driver.findElement(By.xpath("//span[@class='priceBlockStrikePriceString a-text-strike']")).getText().replace("₹", "").replace(".00", "").replace(",", "").replace(" ", "").toString();
                        price = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']")).getText().replace("₹", "").replace(".00", "").replace(",", "").replace(" ", "").toString();
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        price = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']")).getText().replace("₹", "").replace(".00", "").replace(",", "").replace(" ", "").toString();
                        mrp = "NotFound";
                    }

                    if (mrp.equals(value1) && price.equals(value2)) {
                        filewriter.append(value0);
                        filewriter.append(",");
                        filewriter.append(value1);
                        filewriter.append(",");
                        filewriter.append(value2);
                        filewriter.append(",");
                        filewriter.append("MRP Matched");
                        filewriter.append(",");
                        filewriter.append("Price Matched");
                        filewriter.append("\n");
                    } else if (price.equals(value2)) {
                        filewriter.append(value0);
                        filewriter.append(",");
                        filewriter.append(value1);
                        filewriter.append(",");
                        filewriter.append(value2);
                        filewriter.append(",");
                        filewriter.append(mrp);
                        filewriter.append(",");
                        filewriter.append("Price Matched");
                        filewriter.append("\n");

                    } else {
                        filewriter.append(value0);
                        filewriter.append(",");
                        filewriter.append(value1);
                        filewriter.append(",");
                        filewriter.append(value2);
                        filewriter.append(",");
                        if ((mrp.equals(value1) && price !=value2)){
                            filewriter.append("MRP Matched");
                            filewriter.append(",");
                            filewriter.append(price);
                            filewriter.append("\n");
                        }else if((price.equals(value2) && mrp !=value1)) {
                            filewriter.append(mrp);
                            filewriter.append(",");
                            filewriter.append("Price Matched");
                            filewriter.append("\n");
                        }else{
                            filewriter.append(mrp);
                            filewriter.append(",");
                            filewriter.append(price);
                            filewriter.append("\n");
                        }
                    }
                } else {
                    driver.get(value0);
                    Thread.sleep(2000);
                    Actions actions = new Actions(driver);
                    WebElement icon = driver.findElement(By.xpath("//img[@id='price-info-icon']"));
                    actions.moveToElement(icon).clickAndHold().perform();
                    Thread.sleep(1000);
                    List<WebElement> fprice = driver.findElements(By.xpath("//*/div[contains(@class,'_1USjzt')]"));
                    Thread.sleep(1000);
                    String mPrice,fPrice,sPrice;
                    mPrice = fprice.get(0).getText().replace("₹", "").replace(".00", "").replace(",", "").replace(" ", "").toString();
                    fPrice = fprice.get(1).getText().replace("₹", "").replace(".00", "").replace(",", "").replace(" ", "").toString();

                    if (fprice.size() == 2) {
                        if (mPrice.equals(value1) && fPrice.equals(value2)) {
                            filewriter.append(value0);
                            filewriter.append(",");
                            filewriter.append(value1);
                            filewriter.append(",");
                            filewriter.append(value2);
                            filewriter.append(",");
                            filewriter.append("MRP Matched");
                            filewriter.append(",");
                            filewriter.append("Price Matched");
                            filewriter.append("\n");
                        } else {
                            filewriter.append(value0);
                            filewriter.append(",");
                            filewriter.append(value1);
                            filewriter.append(",");
                            filewriter.append(value2);
                            filewriter.append(",");
                            if(mPrice.equals(value1) && fPrice!=value2){
                                filewriter.append("MRP Matched");
                                filewriter.append(",");
                                filewriter.append(fPrice);
                                ;
                                filewriter.append("\n");
                            }else if(mPrice!=value1 && fPrice.equals(value2)){
                                filewriter.append(mPrice);
                                filewriter.append(",");
                                filewriter.append("Price Matched");
                                filewriter.append("\n");
                            }else {

                                filewriter.append(mPrice);
                                filewriter.append(",");
                                filewriter.append(fPrice);                                ;
                                filewriter.append("\n");
                            }
                        }

                    } else {
                        sPrice = fprice.get(2).getText().replace("₹", "").replace(".00", "").replace(",", "").replace(" ", "").toString();

                        if (mPrice.equals(value1) && sPrice.equals(value2)) {
                            filewriter.append(value0);
                            filewriter.append(",");
                            filewriter.append(value1);
                            filewriter.append(",");
                            filewriter.append(value2);
                            filewriter.append(",");
                            filewriter.append("MRP Matched");
                            filewriter.append(",");
                            filewriter.append("Price Matched");
                            filewriter.append("\n");
                        } else {
                            filewriter.append(value0);
                            filewriter.append(",");
                            filewriter.append(value1);
                            filewriter.append(",");
                            filewriter.append(value2);
                            filewriter.append(",");
                            if(mPrice.equals(value1) && sPrice!=value2){
                                filewriter.append("MRP Matched");
                                filewriter.append(",");
                                filewriter.append(sPrice);
                                filewriter.append("\n");
                            }else if(mPrice!=value1 && sPrice.equals(value2)){
                                filewriter.append(mPrice);
                                filewriter.append(",");
                                filewriter.append("Price Matched");
                                filewriter.append("\n");
                            }else {
                                filewriter.append(mPrice);
                                filewriter.append(",");
                                filewriter.append(sPrice);
                                filewriter.append("\n");
                            }

                        }
                    }

                }

            } catch (Exception e) {
                filewriter.append(value0);
                filewriter.append(",");
                filewriter.append("currently unavailable");
                filewriter.append(",");
                filewriter.append("\n");
            }
        }
        filereader.close();
        filewriter.close();
        driver.close();
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

}


