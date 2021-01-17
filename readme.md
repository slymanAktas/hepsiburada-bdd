1. Testler default'da chrome üzerinden koşmaktadır.Firefox üzerinden koşması isteniyorsa terminalde pom.xml'in olduğu 
dizine gidilir ve aşağıdaki komut çalıştırılır.

`mvn clean verify -Dwebdriver.driver=firefox`

2. Testler komut satırından koşulduktan sonra aşağıdaki dizinde yer alan `index.html` üzerinden serenity framework'unun
 kanımca en güçlü yönü olan test raporuna erişilebilir.
 Ekran görüntüleri burada yer almaktadır.

`/serenity-automated-tests/target/site/serenity/index.html`

3. `*.feature` dosyalarının ilk satırında ilgili feature file'lar teg'lenir.(Örn @iade, @iptal ...)
Sonrasında bu taglar vesilesi ile testler gruplar halinde koşulaiblir.
Örn: Tüm @iade tagi ile taglanmiş testleri koşabilmek için terminalden aşağıdaki maven komutu çalıştırılır.

`mvn clean verify -Dtag=iade`
