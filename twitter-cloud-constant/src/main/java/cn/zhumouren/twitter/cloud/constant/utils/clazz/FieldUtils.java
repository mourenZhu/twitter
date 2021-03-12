package cn.zhumouren.twitter.cloud.constant.utils.clazz;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/12 20:35
 * @Version 1.0
 **/
public class FieldUtils {

    /**
     * 把父类中的所有属性值插入子类中
     *
     * @param father
     * @param son
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public static void fatherValueCopyToSonValue(Object father, Object son) throws IllegalAccessException, NoSuchFieldException {

        Class fatherClass = father.getClass();
        List<Field> fatherFieldList = new ArrayList<>();
        while (fatherClass != null) {
            fatherFieldList.addAll(new ArrayList<>(Arrays.asList(fatherClass.getDeclaredFields())));
            fatherClass = fatherClass.getSuperclass();
        }

        for (Field fatherField : fatherFieldList) {
            if (fatherField.getModifiers() != 26) {
                fatherField.setAccessible(true);
                fatherField.set(son, fatherField.get(father));
                fatherField.setAccessible(false);
            }
        }

    }
}
