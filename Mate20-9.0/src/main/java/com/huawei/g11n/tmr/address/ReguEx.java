package com.huawei.g11n.tmr.address;

import java.util.regex.Pattern;

public class ReguEx {
    String bigLett = "[A-Z]";
    String blank = "(?:\\s*,\\s*|\\s+)";
    String blank2 = "(\\s*[,:]\\s*|\\s*)";
    String boundL = "(?<![a-zA-Z])";
    String boundR = "(?![a-zA-Z])";
    String city;
    String cityPre = "(?:(?i)uptown|downtown)";
    String citySuf = "(?:(?i)town|city|county|uptown|downtown)";
    String code = ("(?:(?:" + this.code_a + ")" + "|(?:" + this.code_b + "))");
    String code_a = "(?<!\\d)(?:\\d{5}(?:\\s*-\\s*\\d{4})?)(?!\\d)";
    String code_b = "\\b(?:(?:[A-Z]{1,2}[0-9]{1,2} [0-9][A-Z]{2})|(?:[A-Z]{1,2}[0-9][A-Z] [0-9][A-Z]{2}))\\b";
    String dire = "(?:(?i)[nesw]|north|west|east|south|northeast|northwest|southeast|southwest|ne|nw|se|sw)\\.?";
    String letter = "[A-Za-z]";
    String location;
    String numBig = "[0-9A-Z]";
    String numLett = "[0-9A-Za-z]";
    String number = "[0-9]";
    Pattern p1346;
    Pattern p28;
    Pattern p2s;
    Pattern p52;
    Pattern p52_sub;
    Pattern p52s;
    String post_box;
    String preAll = "(?:(?i)in|on|at|of|from|to|for|near)";
    String preBuilding = "(?:(?i)in|at|to|from|near|reach)";
    String preCity = "(?:(?i)in|at|of|from)";
    String preCityIn = "(?:(?i)in|at|on|of)";
    String preRoad = "(?:(?i)in|at|on)";
    String preState = "(?:(?i)in|of)";
    String pre_s2;
    String pre_s52;
    String punc = "(?:(?:[-&,.])|\\(|\\)|\"|/|\\s)";
    String road;
    String roadSuf = "(?:(?:(?i)boulevard|avenue|street|freeway|road|circle|lane|drive|court|ally|parkway|Crescent|Highway|(?:Ave|AV|Blvd|Cir|Ct|Dr|Ln|Pkwy|Rd|Sq|St|Fwy)\\.?)|Way|WAY)";
    String roadSuf_sub = "(?:(?i)street|boulevard|avenue|lane|ave|av|blvd|ln|rd|st|crescent)(?:\\.?)";
    String road_sub;
    String road_suite;
    String s52;
    String s52_sub;
    String state;
    String sufS = "(?:'s|'S|')";
    String word_1 = (String.valueOf(this.bigLett) + this.letter + "*" + this.sufS + "?");
    String word_2 = (String.valueOf(this.bigLett) + this.numLett + "*" + this.sufS + "?");
    String word_23;
    String word_3 = (String.valueOf(this.number) + this.numLett + "*" + this.letter + this.sufS + "?");
    String word_4;
    String word_5;

    ReguEx() {
        StringBuilder sb = new StringBuilder("(?:");
        sb.append(this.word_2);
        sb.append("|");
        sb.append(this.word_3);
        sb.append(")");
        this.word_23 = sb.toString();
        this.word_4 = String.valueOf(this.numBig) + this.numLett + "*" + this.sufS + "?";
        StringBuilder sb2 = new StringBuilder(String.valueOf(this.numLett));
        sb2.append("+");
        sb2.append(this.sufS);
        sb2.append("?");
        this.word_5 = sb2.toString();
        this.state = "(?:(?:(?i)(?:Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|Minnesota|Lississippi|Missouri|Montana|Nebraska|Nevada|New Jersey|New Mexico|New York|North Carolian|North Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode Island|RL|South Carolina|South Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West Virginia|Wisconsin|Wyoming|AL|WY|AK|AZ|AR|CA|Co|CT|DE|FL|GA|ID|IL|IA|KS|KY|LA|MD|MA|MI|MN|MS|MO|MT|NE|NV|NJ|NM|NY|NC|ND|PA|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI))|(?:HI|OR|ME|OK|OH))\\.?(?:(?i)\\s+state)?";
        this.location = "(?:(?:(?i)(?:park|center|hotel|bar|hospital|theater|theatre|building|lounge|store|market|apartment|restaurant|museum|university|college|school|tower|guesthouse|mansion|motel|club|cafe|airport|stadium|station|bridge|bodega|tavern|boutique|zoo|mall|bkstore|inn|hostel|resort|institute|library|kingdergarten|cafeteria|bistro|canteen|hall|castle|garden|square|plaza|gallery|pier|wharf|shop|outlet|supermarket|district|clinic|cinema|gym|gymnasium|bowl|bus\\s+station|train\\s+station))|(?:House|HOUSE))";
        this.road_suite = "(?:\\d+th\\s+)?" + this.boundL + "suite" + "(?:(?:\\s*\\d+(?:\\s*-?\\s*" + this.letter + ")?)|(?:\\s+" + this.letter + ")|(?:(?i)\\s+level(?:\\s+" + this.letter + "?)))?(?!\\w)";
        this.road = "(?:(?<![a-zA-Z0-9])(?:(?:(?:(?:#)?\\d+(?:-\\d+)?)" + this.blank + "(?:" + this.dire + "\\s+)?)?" + "(?:" + this.word_23 + "(?:\\s+(?:(?i)(?:and|&)\\s+)?))*?" + this.word_23 + "\\s+" + this.roadSuf + this.boundR + "(?:\\s+" + this.dire + this.boundR + ")?" + "(?:" + this.blank + this.road_suite + ")?" + "))";
        this.city = "(((?:" + this.cityPre + "\\s+)?(?:" + this.word_1 + "\\s+(?:" + this.preCityIn + "\\s+)?){0,3}?" + this.word_1 + "(?:\\s+" + this.citySuf + ")?" + "(?:" + this.blank + "(?:" + this.preState + "\\s+)?" + this.state + "))" + "|(?:(?:" + this.cityPre + "\\s+)?(?:" + this.word_1 + "\\s+(?:" + this.preCityIn + "\\s+)?){0,3}" + this.word_1 + "))" + this.boundR;
        StringBuilder sb3 = new StringBuilder(String.valueOf(this.boundL));
        sb3.append("(?i)");
        sb3.append("(?:(?:PO\\s*BOX\\s*\\d+(?:\\s+PMB\\s*\\d+)?)");
        sb3.append("|(?:(?:Rural\\s+Route)|(?:RR))\\s*\\d+\\s+BOX\\s*\\d+\\s+PMB\\s*\\d+");
        sb3.append("|\\d+\\s+PMB\\s*\\d+(?:(?:(?:Rural\\s+Route)|(?:RR))\\s*\\d+\\s+BOX\\s*\\d+)?)");
        this.post_box = sb3.toString();
        this.s52 = "((?:" + this.road + this.blank + "(?:(?i)(?:and|&)\\s+)?" + ")*" + this.road + ")" + "(" + "(" + this.blank + "(?:" + this.preCity + "\\s+)?)" + "(" + this.post_box + this.blank + ")?" + this.city + "(" + this.blank + this.code + ")?" + ")?";
        StringBuilder sb4 = new StringBuilder("(\\W+(?:");
        sb4.append(this.preRoad);
        sb4.append("\\s+(?:the\\s+)?)?|\\W+)");
        this.pre_s52 = sb4.toString();
        this.pre_s2 = "(\\W+(?:(?i)(?:in|at|of|from)\\s+(?:the\\s+)?)?|\\W+)";
        this.p52 = Pattern.compile(this.s52);
        StringBuilder sb5 = new StringBuilder(String.valueOf(this.pre_s52));
        sb5.append(this.s52);
        this.p52s = Pattern.compile(sb5.toString());
        StringBuilder sb6 = new StringBuilder(String.valueOf(this.pre_s2));
        sb6.append("(");
        sb6.append(this.post_box);
        sb6.append(this.blank);
        sb6.append(")?");
        sb6.append(this.city);
        sb6.append("(?:");
        sb6.append(this.blank2);
        sb6.append("(");
        sb6.append(this.code);
        sb6.append("))?");
        this.p2s = Pattern.compile(sb6.toString());
        this.p1346 = Pattern.compile("(?:" + this.boundL + this.preBuilding + "\\s+(?:(?i)the\\s+)?)?" + this.boundL + "(?:(?:(?:" + this.word_4 + "|south|east|north|west)" + this.boundR + "\\s*)" + "|" + this.location + this.boundR + "\\s*)" + "(?:" + "((?:" + this.boundL + this.word_4 + this.boundR + ")*)" + "(?:(?:" + this.boundL + this.location + this.boundR + "|" + this.boundL + this.preAll + this.boundR + "|" + this.boundL + this.citySuf + this.boundR + "|" + this.punc + "|" + this.boundL + "(?:(?i)and)" + this.boundR + "|" + this.boundL + this.state + this.boundR + "|" + this.boundL + this.roadSuf + this.boundR + "|(?<![a-zA-Z'])" + this.dire + this.boundR + "|" + this.boundL + "(?:(?i)the)" + this.boundR + ")*)" + ")*");
        StringBuilder sb7 = new StringBuilder("((");
        sb7.append(this.post_box);
        sb7.append(this.blank);
        sb7.append(")?");
        sb7.append(this.city);
        sb7.append(")?");
        sb7.append(this.blank2);
        sb7.append("(");
        sb7.append(this.code);
        sb7.append(")");
        this.p28 = Pattern.compile(sb7.toString());
        StringBuilder sb8 = new StringBuilder("(?:");
        sb8.append(this.boundL);
        sb8.append("(?:");
        sb8.append(this.preRoad);
        sb8.append("(?:\\s+");
        sb8.append(this.number);
        sb8.append("{3,5})?|(?:");
        sb8.append(this.preRoad);
        sb8.append("\\s+)?");
        sb8.append(this.number);
        sb8.append("{3,5})");
        sb8.append("\\s+(?:");
        sb8.append(this.word_5);
        sb8.append("\\s+){1,3}");
        sb8.append(this.roadSuf_sub);
        sb8.append(this.boundR);
        sb8.append("(?:\\s+");
        sb8.append(this.dire);
        sb8.append(this.boundR);
        sb8.append(")?");
        sb8.append("(?:");
        sb8.append(this.blank);
        sb8.append(this.road_suite);
        sb8.append(")?)");
        this.road_sub = sb8.toString();
        this.s52_sub = "(" + this.road_sub + ")" + "(" + "(" + this.blank + "(?:" + this.preCity + "\\s+)?)" + "(" + this.post_box + this.blank + ")?" + this.city + "(" + this.blank + this.code + ")?" + ")?";
        this.p52_sub = Pattern.compile(this.s52_sub);
    }
}
