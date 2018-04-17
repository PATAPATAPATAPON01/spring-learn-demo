package chapter2.dozer;

import chapter2.dozer.dozer_2.NotSameAttributeA;
import chapter2.dozer.dozer_2.NotSameAttributeB;
import chapter2.dozer.dozer_2.SourceBean;
import chapter2.dozer.dozer_2.TargetBean;
import com.sun.tools.javac.util.List;
import org.assertj.core.util.Lists;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.dozer.classmap.RelationshipType;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;
import org.junit.Test;
import org.mockito.cglib.beans.BeanCopier;
import org.mockito.cglib.core.Converter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;

import static javafx.scene.input.KeyCode.T;
import static org.dozer.loader.api.FieldsMappingOptions.*;
import static org.dozer.loader.api.TypeMappingOptions.mapId;
import static org.dozer.loader.api.TypeMappingOptions.mapNull;

/**
 * @version :1.0.0
 * @author: term
 * @time: 2018-04-14 21:32
 * @description :
 */
public class MainTest {

    @Test
    public void method() {
        DozerBeanMapper beanMapper = new DozerBeanMapper();

        NotSameAttributeA_OBJECT attributeA = new NotSameAttributeA_OBJECT(1, "lvjian", new Date());
        NotSameAttributeB_OBJECT attributeB = new NotSameAttributeB_OBJECT();
        attributeA.setList(List.of("a", "b", "e"));
        beanMapper.map(attributeA, attributeB);


        NotSameAttributeB_OBJECT b = beanMapper.map(attributeA, NotSameAttributeB_OBJECT.class);
        System.out.println(b);

    }


    @Test
    public void method1() {

//        ArrayList<String> mappingFiles = Lists.newArrayList();
//        mappingFiles.add("dozerBeanMapping.xml");
//        DozerBeanMapper mapper = new DozerBeanMapper();
//
//        mapper.setMappingFiles(mappingFiles);
//
        NotSameAttributeA attributeA = new NotSameAttributeA();
        attributeA.setDate(new Date());
        attributeA.setId(100);
        attributeA.setName("lvjian");
//        NotSameAttributeB attributeB = mapper.map(attributeA, NotSameAttributeB.class);
//        System.out.println(attributeB);


        Mapper instance = DozerBeanMapperSingletonWrapper.getInstance();
        NotSameAttributeB bb = instance.map(attributeA, NotSameAttributeB.class);
        System.out.println(bb);
    }


    @Test
    public void method2() {

        SourceBean sourceBean = new SourceBean();
        sourceBean.setData("-data");
        sourceBean.setId(100l);
        sourceBean.setName("-name");
        TargetBean targetBean = new DozerBeanMapper().map(sourceBean, TargetBean.class);
        System.out.println(targetBean);
        TargetBean bean = new TargetBean();
        bean.setPk("22222");
        bean.setBinaryData("binaryData");
        bean.setName("dodo-name");

        System.out.println(new DozerBeanMapper().map(bean, SourceBean.class));
    }


    @Test
    public void method3() {

        new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(SourceBean.class, TargetBean.class, TypeMappingOptions.oneWay(),

                        mapId("A"),

                        mapNull(true)

                ).exclude("excluded").fields("src", "dest",

                        copyByReference(),

                        collectionStrategy(true,

                                RelationshipType.NON_CUMULATIVE),

                        hintA(String.class),

                        hintB(Integer.class),

                        FieldsMappingOptions.oneWay(),

                        useMapId("A"),

                        customConverterId("id")

                ).fields("src", "dest",

                        customConverter("org.dozer.CustomConverter")

                );
            }
        };


    }

    @Test
    public void method4() {
        BeanCopier copier = BeanCopier.create(SourceBean.class, TargetBean.class, true);
//        BeanUtils.copyProperties(); 复制是用过自省 自省使用的反射
//        org.apache.commons.beanutils.BeanUtils.copyProperties();
        SourceBean sourceBean = new SourceBean();
        sourceBean.setData("-data");
        sourceBean.setId(100l);
        sourceBean.setName("-name");
        TargetBean targetBean = new TargetBean();
        copier.copy(sourceBean, targetBean, new Converter() {
            @Override
            public Object convert(Object o, Class aClass, Object o1) {
                System.out.println(o+"  "+  aClass+"   "+o1);
                return null;
            }
        });
    }
}
