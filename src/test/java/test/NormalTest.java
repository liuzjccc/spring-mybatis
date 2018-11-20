package test;

import com.liuzj.mybatis.common.utils.ArrayUtil;
import com.liuzj.mybatis.common.utils.ParamNameUtil;
import com.sun.deploy.util.ParameterUtil;

import java.util.List;

public class NormalTest {
    public static void main(String[] args) throws NoSuchMethodException {
        NormalTest normalTest = new NormalTest();
        List<String> params = ParamNameUtil.getParamNames(normalTest.getClass().getMethod("testMethod", String.class));
    }

    public void testMethod(String aa){
        {
            System.out.println(1);
        }
        {
            System.out.println(2);
        }
        {
            System.out.println(3);
        }
    }
}

