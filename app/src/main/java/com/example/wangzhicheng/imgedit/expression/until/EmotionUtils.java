package com.example.wangzhicheng.imgedit.expression.until;

import com.example.wangzhicheng.imgedit.R;

import java.util.LinkedHashMap;


/**
 * Created by wangzhicheng
 */

public class EmotionUtils {
    /**
     * 表情类型标志符
     */
    public static final int EMOTION_CLASSIC_TYPE=0x0001;//经典表情
    public static final int LU_CLASSIC_TYPE=0x0002;//鹿表情

    /**
     * key-表情文字;
     * value-表情图片资源
     */
    public static LinkedHashMap<String, Integer> EMPTY_MAP;
    public static LinkedHashMap<String, Integer> EMOTION_CLASSIC_MAP;
    public static LinkedHashMap<String,Integer> LU_CLASSIC_MAP;


    static {
        EMPTY_MAP = new LinkedHashMap<>();
        EMOTION_CLASSIC_MAP = new LinkedHashMap<>();
        LU_CLASSIC_MAP=new LinkedHashMap<>();

        EMOTION_CLASSIC_MAP.put("[馋嘴]",R.drawable.emoji000);
        EMOTION_CLASSIC_MAP.put("[哈哈]", R.drawable.emoji001);
        EMOTION_CLASSIC_MAP.put("[微笑]",R.drawable.emoji002);
        EMOTION_CLASSIC_MAP.put("[嘻嘻]",R.drawable.emoji003);
        EMOTION_CLASSIC_MAP.put("[可爱]",R.drawable.emoji004);
        EMOTION_CLASSIC_MAP.put("[眨眼]",R.drawable.emoji005);
        EMOTION_CLASSIC_MAP.put("[花心]",R.drawable.emoji006);
        EMOTION_CLASSIC_MAP.put("[爱你]",R.drawable.emoji007);
        EMOTION_CLASSIC_MAP.put("[亲吻]",R.drawable.emoji008);
        EMOTION_CLASSIC_MAP.put("[发呆]",R.drawable.emoji009);
        EMOTION_CLASSIC_MAP.put("[闭眼]",R.drawable.emoji010);
        EMOTION_CLASSIC_MAP.put("[呵呵]",R.drawable.emoji011);
        EMOTION_CLASSIC_MAP.put("[鬼脸]",R.drawable.emoji012);
        EMOTION_CLASSIC_MAP.put("[吐舌]",R.drawable.emoji013);
        EMOTION_CLASSIC_MAP.put("[鄙视]",R.drawable.emoji014);
        EMOTION_CLASSIC_MAP.put("[阴险]",R.drawable.emoji015);
        EMOTION_CLASSIC_MAP.put("[汗]",R.drawable.emoji016);
        EMOTION_CLASSIC_MAP.put("[失望]",R.drawable.emoji017);
        EMOTION_CLASSIC_MAP.put("[无奈]",R.drawable.emoji018);
        EMOTION_CLASSIC_MAP.put("[皱眉]",R.drawable.emoji019);
        EMOTION_CLASSIC_MAP.put("[悲伤]",R.drawable.emoji020);
        EMOTION_CLASSIC_MAP.put("[泪]",R.drawable.emoji021);
        EMOTION_CLASSIC_MAP.put("[大哭]",R.drawable.emoji022);
        EMOTION_CLASSIC_MAP.put("[恐怖]",R.drawable.emoji023);
        EMOTION_CLASSIC_MAP.put("[生气]",R.drawable.emoji024);
        EMOTION_CLASSIC_MAP.put("[怒]",R.drawable.emoji025);
        EMOTION_CLASSIC_MAP.put("[睡觉]",R.drawable.emoji026);
        EMOTION_CLASSIC_MAP.put("[生病]",R.drawable.emoji027);
        EMOTION_CLASSIC_MAP.put("[哭笑]",R.drawable.emoji028);
        EMOTION_CLASSIC_MAP.put("[星眼]",R.drawable.emoji029);
        EMOTION_CLASSIC_MAP.put("[失落]",R.drawable.emoji030);
        EMOTION_CLASSIC_MAP.put("[哎呀]",R.drawable.emoji031);
        EMOTION_CLASSIC_MAP.put("[茫然]",R.drawable.emoji032);
        EMOTION_CLASSIC_MAP.put("[good]",R.drawable.emoji101);
        EMOTION_CLASSIC_MAP.put("[弱]",R.drawable.emoji102);
        EMOTION_CLASSIC_MAP.put("[ok]",R.drawable.emoji103);
        EMOTION_CLASSIC_MAP.put("[耶]",R.drawable.emoji104);
        EMOTION_CLASSIC_MAP.put("[鼓掌]",R.drawable.emoji105);
        EMOTION_CLASSIC_MAP.put("[心]",R.drawable.emoji106);
        EMOTION_CLASSIC_MAP.put("[心碎]",R.drawable.emoji107);
        EMOTION_CLASSIC_MAP.put("[闪耀]",R.drawable.emoji108);
        EMOTION_CLASSIC_MAP.put("[困]",R.drawable.emoji109);
        EMOTION_CLASSIC_MAP.put("[亲嘴]",R.drawable.emoji110);
        EMOTION_CLASSIC_MAP.put("[汉堡]",R.drawable.emoji201);
        EMOTION_CLASSIC_MAP.put("[薯条]",R.drawable.emoji202);
        EMOTION_CLASSIC_MAP.put("[便当]",R.drawable.emoji203);
        EMOTION_CLASSIC_MAP.put("[寿司]",R.drawable.emoji204);
        EMOTION_CLASSIC_MAP.put("[饭团]",R.drawable.emoji205);
        EMOTION_CLASSIC_MAP.put("[饭]",R.drawable.emoji206);
        EMOTION_CLASSIC_MAP.put("[拉面]",R.drawable.emoji207);
        EMOTION_CLASSIC_MAP.put("[面包]",R.drawable.emoji208);
        EMOTION_CLASSIC_MAP.put("[蛋筒]",R.drawable.emoji209);
        EMOTION_CLASSIC_MAP.put("[沙冰]",R.drawable.emoji210);
        EMOTION_CLASSIC_MAP.put("[蛋糕]",R.drawable.emoji211);
        EMOTION_CLASSIC_MAP.put("[甜点]",R.drawable.emoji212);
        EMOTION_CLASSIC_MAP.put("[苹果]",R.drawable.emoji213);
        EMOTION_CLASSIC_MAP.put("[橙子]",R.drawable.emoji214);
        EMOTION_CLASSIC_MAP.put("[西瓜]",R.drawable.emoji215);
        EMOTION_CLASSIC_MAP.put("[草莓]",R.drawable.emoji216);
        EMOTION_CLASSIC_MAP.put("[咖啡]",R.drawable.emoji217);
        EMOTION_CLASSIC_MAP.put("[茶]",R.drawable.emoji218);
        EMOTION_CLASSIC_MAP.put("[啤酒]",R.drawable.emoji219);
        EMOTION_CLASSIC_MAP.put("[饮料]",R.drawable.emoji220);
        EMOTION_CLASSIC_MAP.put("[酒]",R.drawable.emoji221);
        EMOTION_CLASSIC_MAP.put("[刀叉]",R.drawable.emoji222);
        EMOTION_CLASSIC_MAP.put("[浪漫]",R.drawable.emoji301);
        EMOTION_CLASSIC_MAP.put("[情侣]",R.drawable.emoji302);
        EMOTION_CLASSIC_MAP.put("[按摩]",R.drawable.emoji303);
        EMOTION_CLASSIC_MAP.put("[美发]",R.drawable.emoji304);
        EMOTION_CLASSIC_MAP.put("[美甲]",R.drawable.emoji305);
        EMOTION_CLASSIC_MAP.put("[篮球]",R.drawable.emoji306);
        EMOTION_CLASSIC_MAP.put("[足球]",R.drawable.emoji307);
        EMOTION_CLASSIC_MAP.put("[网球]",R.drawable.emoji308);
        EMOTION_CLASSIC_MAP.put("[桌球]",R.drawable.emoji309);
        EMOTION_CLASSIC_MAP.put("[游泳]",R.drawable.emoji310);
        EMOTION_CLASSIC_MAP.put("[猫]",R.drawable.emoji311);
        EMOTION_CLASSIC_MAP.put("[狗]",R.drawable.emoji312);
        EMOTION_CLASSIC_MAP.put("[仓鼠]",R.drawable.emoji313);
        EMOTION_CLASSIC_MAP.put( "[兔子]",R.drawable.emoji314);
        EMOTION_CLASSIC_MAP.put("[小猪]",R.drawable.emoji315);
        EMOTION_CLASSIC_MAP.put("[樱花]",R.drawable.emoji316);
    }
    /**
     * 根据名称获取当前表情图标R值
     * @param EmotionType 表情类型标志符
     * @param imgName 名称
     * @return
     */
    public static int getImgByName(int EmotionType,String imgName) {
        Integer integer=null;
        switch (EmotionType){
            case EMOTION_CLASSIC_TYPE:
                integer = EMOTION_CLASSIC_MAP.get(imgName);
                break;
            case LU_CLASSIC_TYPE:
                integer=LU_CLASSIC_MAP.get(imgName);
                break;
            default:
                break;
        }
        return integer == null ? -1 : integer;
    }

    /**
     * 根据类型获取表情数据
     * @param EmotionType
     * @return
     */
    public static LinkedHashMap<String, Integer> getEmojiMap(int EmotionType){
        LinkedHashMap EmojiMap=null;
        switch (EmotionType){
            case EMOTION_CLASSIC_TYPE:
                EmojiMap=EMOTION_CLASSIC_MAP;
                break;
            case LU_CLASSIC_TYPE:
                EmojiMap=LU_CLASSIC_MAP;
                break;
            default:
                EmojiMap=EMPTY_MAP;
                break;
        }
        return EmojiMap;
    }
}
