regdom4j - Detect registered domain library for Java
====================================================

regdom4j is registerd domain detector for Java.
Original implementation is [reg-dom-libs][www.dkim-reputation.org/regdom-libs/]

## Command Line Usage

    $ java -jar regdom4j.jar www.example.com
    > example.com
    
    $ java -jar regdom4j.jar www.example.co.jp
    > example.co.jp
    
    $ java -jar regdom4j.jar www.example.shinagawa.tokyo.jp
    > example.shinagawa.tokyo.jp

## Library Usage

    import jp.co.osstech.regdom4j.RegDomain;

    RegDomain regdom = new RegDomain();
    String result = regdom.getRegisteredDomain("example.com");

## Javadoc
TODO :-p

## Auther
HAMANO Tsukasa <hamano@osstech.co.jp>

## License
Apache License, Version 2.0
http://www.apache.org/licenses/LICENSE-2.0
