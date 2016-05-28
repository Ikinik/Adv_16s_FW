---------------------------------
    Adventura: Konec přichází
---------------------------------
Autor: Adam Šorfa, xname: sora00
Verze: 1.0

Popis programu:
Jedná se o jednoduchou textovou hru, naprogramovanou v jazyce Java. Hru je možné
spouštět ve dvou režimech:
    - Jako okenní aplikaci - hra přijímá příkazy skrze dialogová okna
    - Jako konzolovou aplikaci - hra pracuje se standartním vstupem a výstupem
Ve hře je možné procházet prostory, přenášet, sbírat a používat různé předměty.
Objevovat nové a pomocí jejich kombinací vytvářet další.

Spuštění:
    - okenní aplikace:
        - soubor.jar - dvojkilk
        - příkazový řádek: java -jar <soubor.jar>
    - Konzolá aplikace:
        java -jar <soubor.jar> -con

-----------------------
  Poznámky k programu
-----------------------
  Ve hře nepoužívám žádné další veřejné datové atributy. Atributy jsou
  nastaveny jako private. Komunikaci s nimi obstarávají getry a setry.

Seznam příkazů pro ovládání hry:

    - Jdi (cíl) Přesune hráče do prostoru cíl, který musí být aktuální sousedem
                prostoru, v němž se hráč právě nachází.

    - Seber (co) Sebere věc z aktuálního prostoru a umísí jí do batohu.

    - Polož (co) Položí věc z batohu na zem.

    - Rozhlédni-se Vypíše název aktuálného prostoru, věci nacházející se unitř
                   a sousední prostory. Vypíše také aktuální obsah batohu.

    - Použij (co, na co) Použije věc v batohu na věc umístěnou v aktuálnín
                         prostoru.

    - Skombinuj (co, sčím) Skombinuje dvě věci v batohu na vytvoří tak novou
                           věc.

    - Tancuj Zatancuje pro pobavení.

    - Prozkoumej (co) Prozkoumá předmět v aktuálním prostoru. Pokud předmět
                      obsahuje nějaké další skryté předměty, jou po prozkoumání
                      umístěny do aktuálního prostoru.

    - ? Příkaz pro vyvolání nápovědy. Vypíše základní nápovědu, která hráči
        poradí, jakým směrem by se měl ubírat, aby hru úspěšně dohrál podle
        základního scénáře.

    - Konec Předčasně ukončí hru.