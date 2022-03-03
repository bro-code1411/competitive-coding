import org.junit.Test;

public class TestCase {

    public Dictionary dictionary = new Dictionary();

    @Test
    public void test(){
        dictionary.enterKey( "hello");
        dictionary.enterKey( "hell");
        dictionary.enterKey( "bar");
        dictionary.enterKey( "bra");
        dictionary.enterKey("helloworld");

        assert (dictionary.find("helol", 2) == true);

    }

    @Test
    public void testNegative(){
        dictionary.enterKey( "hello");
        dictionary.enterKey( "hell");
        dictionary.enterKey( "bar");
        dictionary.enterKey( "bra");
        dictionary.enterKey("helloworld");

        assert (dictionary.find("lol", 2) == false);

    }
}
