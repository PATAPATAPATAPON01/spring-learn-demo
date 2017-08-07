package spring.learn.chapter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: za-lvjian
 * Date: 2017/8/7 15:33
 * DESC:
 */
@Service
@Data
public class TestBean {

    @Value("#{blankDisc}")
    private BlankDisc blankDisc;


    @Value("#{blankDisc.artist}")
    private String blankTitle;


    @Value("#{blankDisc.selectList()?.toUpperCase()}")
    private String testMethod;


    @Value("#{T(java.lang.Math).PI}")
    private double PI;


    @Value("#{T(Math).abs(0.2d)}")
    private String myConst;


    @Value("#{T(Math).random()}")
    private float randomNum;


    @Value("#{2*T(Math).PI}")
    private double mianJi;

    @Value("#{2^2}")
    private int MI_DENG;


    @Value("#{blankDisc.artist+'--dododod--'+blankDisc.selectList()}")
    private String contactStr;


    @Value("#{blankDisc.count==100}")
    private boolean result;

    @Value("#{blankDisc.count eq 100}")
    private boolean result2;

    @Value("#{blankDisc.count ge 100 ? 'winnner':'loser'}")
    private String winnerOrLoser;


    @Value("#{blankDisc.selectList()?:'isNull'}")
    private String nullOrNot;

}
