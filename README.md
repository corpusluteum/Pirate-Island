# Pirate-Island (LibGDX ile yapılmış platform oyunu)

LibGDX oyun kütüphanesi açık kaynak(open source) bir kütüphanedir. Projenin dokümantasyonu Wiki sayfası üzerinden yapılmakta. Kütüphane, Java programlama dili üzerine yazılmış.

LibGDX ile geliştirilen bir uygulama tek bir proje üzerinde geliştirilir ve masaüstü, Android, iOS, Html gibi platformlara çıkartılabilir; '/core' dosyası altına oyun(java) classları yazılır ve farklı platformlar için farklı ayarlamalar '/android' , '/desktop' vs. altına yazılabilir.

LibGDX ile oyun geliştirebilmek için projeyi şöyle oluşturuyoruz; https://github.com/libgdx/libgdx/wiki/Project-Setup-Gradle 

Prite-Island için '/core' altında oluşturduğum kalsörlerim:

 	buttons
	collision 	
	controller 	
	drawer 	
	gameObject 	
	handler 	
	imageLoader 	
	inputHandler 
	level 	
	soundLoader 
	states
 	
	StartIslandMenu.java
StartIslandMenu.java classında oyunun State'lerini başlatıyoruz. 

Not: Bu proje, desktop ve android için çalışır ve projede fizik motoru kullanılmamıştır.
