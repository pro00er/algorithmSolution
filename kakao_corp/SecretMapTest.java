import org.junit.Assert;
import org.junit.Test;

public class SecretMapTest {
    @Test
    public void orResultStringTest() {
        SecretMap secretMap = new SecretMap();
        Assert.assertEquals(secretMap.orResultString(1,20,5), "10101");
        Assert.assertEquals(secretMap.orResultString(33,19,6), "110011");
    }

    @Test
    public void convertBinaryStringToMapTest() {
        SecretMap secretMap = new SecretMap();
        String binaryString = secretMap.orResultString(33,19,6);
        Assert.assertEquals("## ##", secretMap.convertBinaryStringToMap(binaryString));
    }
}
