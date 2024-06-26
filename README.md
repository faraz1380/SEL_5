# گزارش آزمایش پنجم آزمایشگاه نرم‌افزار

## راه‌اندازی yourkit
![Image1: Setup yourkit](image/1.png)

## بررسی کلاس JavaCup
طبق گزارش yourkit در تصویر زیر 96% از مصرف کل متعلق به تابع temp() بوده.
![Image2: CPU usage by temp()](image/2.png)
![Image3: CPU usage by temp()](image/3.png)
مصرف حافظه را در دو پروفایلر بررسی کردیم، اولی مربوط به پروفایلر خود intellij است که نشان می‌دهد ()temp بیشترین حافظه را گرفته و دومی نیز data type بیشترین مصرف کننده را نشان می‌دهد.
![Image4: Memory usage by temp()](image/4.png)
![Image5: Memory usage by temp()](https://github.com/faraz1380/SEL_5/assets/63359673/c940fc3b-775b-47a9-a87d-d78e6196e0d8)

همانطور که مشخص است این تابع نقشی در عملکرد اصلی کار ندارد و می‌توان آن را حذف نمود ولی اگر بخواهیم همین کد را بهینه کنیم طبق تصویر زیر ArrayList بودن نوع داده هزینه‌ی زیادی دارد، پس آن را تغییر می‌دهیم و مطابق تصویر زیرین کد جدید را می‌نویسیم.
![Image6](image/5.png)
![Image7](image/6.png)

پس از اجرای دوباره با yourkit دیگر hotspot ی شناسایی نشده و در زیر 1 میلی ثانیه اجرای برنامه به اتمام می‌رسد.
![Image8](image/7.png)

## اضافه کردن کلاس PrimeChecker
برای بررسی زمان و حافظه‌ی مصرفی یک الگوریتم دیگر توسط yourkit از دو الگوریتم برای چک کردن اعداد اول استفاده می‌کنیم. مطابق تصویر زیر تابع isPrimeInefficient یک تابع غیر بهینه و isPrimeOptimized نسخه‌ی بهینه‌ی آن است. برای اینکه تمایز بین این دو بیشتر دیده شود از 50 عدد 10 رقمی استفاده کرده‌ایم.
![Image10](image/10.png)
![image](https://github.com/faraz1380/SEL_5/assets/63359673/5025d7c9-b1cf-455f-8cfb-ea874bf0103d)


در ابتدا تنها isPrimeInefficient را اجرا می‌کنیم و می‌بینیم که توسط yourkit به عنوان Hotspot شناسایی شده که 100% از مصرف پردازنده را به خود اختصاص داده.
![Image11](image/9.png)
اما اگر هر دو را با هم اجرا کنیم می‌بینیم که 99% از اجرا مطابق تصویر زیر متعلف به isPrimeInefficient بوده. دیگر نیازی به اجرای جداگانه‌ی isPrimeOptimized نبود چون hotspot شناخته نشد.
![Image11](image/11.png)

دو تصویر زیر هم تفاوت در حافظه را نشان می‌دهند که قابل چشم پوشی است چون هر دو از نظر حافظه مشابه عمل می‌کنند. (تصویر دوم مربوط به زمانی است که هر دو با هم اجرا شده‌اند برای همین بیشتر زمان برده)

![Image11](image/8.png)
![Image11](image/12.png)
