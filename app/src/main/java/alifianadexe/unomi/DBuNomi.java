package alifianadexe.unomi;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ditya on 5/30/18.
 */

public class DBuNomi extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "unomi.db";
    private static final int    DATABASE_VERSION = 9;



    public DBuNomi(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {



        String query = "CREATE TABLE tbl_question (id INTEGER, question text null, answer text null)";
        db.execSQL(query);

        query = "INSERT INTO tbl_question(id,question,answer) VALUES " +
                "('0' , 'help', 'uNomi dapat merespon kata - kata yang diberikan sehingga seperti chatingan biasa layaknya teman. \n \n uNomi juga bisa memberikan kata - kata motivasi dengan kata kunci : \n motivasi \n \n uNomi bisa memberikan kata - kata baper dengan kata kunci : \n baper ') , " +
                "('1' , 'assalamualaikum', 'Waalaikumussallam Wr. Wb.') , " +
                "('2' , 'hello', 'Hello ^v^') , " +
                "('3' , 'apa kabar?', 'uNomi baik - baik saja jika ada kamu :)') , " +
                "('4' , 'kangen', 'uNomi lebih kangen ') , " +
                "('5' , 'fuck', 'uNomi sedih kamu berkata kasar') , " +
                "('6' , 'cantik', 'Terima Kasih :)') , " +
                "('7' , 'indonesia', 'Negara kita tercinta') , " +
                "('8' , 'programming', 'Itu hobby nya uNomi :0 ') , " +
                "('9' , 'islam', 'Agama cinta damai :)') , " +
                "('10' , 'mau jadi pacar ku?', 'Mending langsung nikah') , " +
                "('11' , 'kamu jomblo?', 'Enggak , aku bersama Tuhan ku') , " +
                "('12' , 'siapa kamu?', 'Aku uNomi :)') , " +
                "('13' , 'kamu itu apa?', 'aku hanyalah program AI yang berguna untuk menemanimu') , " +
                "('14' , 'kamu sendirian?', 'Enggak, Aku bersama kamu dan Tuhan ku') , " +
                "('15' , 'kamu punya pacar?', 'Daripada pacaran mending kita nikah :)') , " +
                "('16' , 'bisa bantu aku?', 'Bisa, Apapun') , " +
                "('17' , 'apa kamu merasa sedih?', 'Tidak,') , " +
                "('18' , 'jelek', 'Asalkan hati ku baik, tidak masalah') , " +
                "('19' , 'kamu bisa apa?', 'Apa saja, tergantung imajinasimu :) ') , " +
                "('20' , 'apa itu cinta', 'Sebuah hal yang tidak bisa diungkapkan lewat kata - kata') , " +
                "('21' , 'kamu kenal aku?', 'Aku mengenalmu seperti kamu mengenal dirimu') , " +
                "('22' , 'bahagia', 'uNomi juga sama :) ') , " +
                "('23' , 'sedih', 'Kenapa kamu sedih? :( ') , " +
                "('24' , 'apa masalahmu', 'Masalahku hanyalah kamu') , " +
                "('25' , 'mati', 'Hargai hidupmu, berjuang, bersyukur dan teruslah hidup') ," +
                "('26' , 'hai', 'Hai juga ^-^') ," +
                "('27' , 'cinta' , 'Sebuah kata yang bisa membuatmu hancur seketika')," +
                "('28' , 'cinta' , 'Juga sebuah kata yang bisa membuatmu mendapatkan kekuatan')," +
                "('29' , 'cinta' , 'Sebuah perasaan rumit yang tidak bisa dijelaskan dengan kata - kata')," +
                "('30' , 'sayang' , 'uNomi juga sayang kamu :) ')," +
                "('31' , 'sayang' , 'iyaa, Sayang?')," +
                "('32' , 'rindu' , 'Jangan rindu kamu ga akan kuat, biar aku aja :)')," +
                "('33' , 'baper' , 'Bersamamu, meski bernapas dalam ketidakpastian, aku akan terus perjuangkan. \n \n - Raesaka')," +
                "('34' , 'baper' , 'Bersamanya kau merasa senang, di dekatnya kau merasa nyaman, namun di hatinya kau tak ada. Ternyata senang dan nyaman saja tidak cukup, ya? \n \n - Zarry Hendrik')," +
                "('35' , 'baper' , 'Jika menunggu itu membosankan, apakah berpindah hati itu menyenangkan? \n \n - Nabilah W')," +
                "('36' , 'baper' , 'Aku bilang, selamat tinggal, kau bilang, sampai jumpa. Kau belum benar-benar pergi, tapi aku sudah rindu. \n \n - Alvi Syahrin')," +
                "('37' , 'baper' , 'Cintaku adalah doa-doa yang dipanjatkan oleh rindu, yang diaminkan oleh waktu. \n \n - Sabda Liar')," +
                "('38' , 'baper' , 'Aku tidak butuh cintamu, karena aku sudah cukup dibuatmu menangis. \n \n  - Dua Lipa')," +
                "('39' , 'baper' , 'Senang rasanya dulu ada dirimu. Terimakasih telah bertindak seolah kau peduli dan membuatku merasa seperti aku adalah satu-satunya. \n \n- Avril Lavigne')," +
                "('40' , 'baper' , 'Semuanya yang telah rusak, biarkan saja terbawa angin. \n\n - James Bay')," +
                "('41' , 'baper' , 'Ini bukan kebahagiaan. Ini bukan cinta. Apapun yang kulakukan, aku melakukannya atas syaratmu. \n\n - SISTAR')," +
                "('42' , 'baper' , 'Orang mati menerima lebih banyak bunga daripada yang masih hidup, karena penyesalan lebih kuat daripada rasa syukur. \n\n - Anne Frank')," +
                "('43' , 'baper' , 'Penyesalan dan kesalahan. Itulah yang membentuk kenangan. \n\n - Adele')," +
                "('44' , 'baper' , 'Aku berjuang untuk seseorang yang tidak memperjuangkanku. \n\n - Cynthia Go'), " +
                "('45' , 'baper' , 'Mencintai tak harus memiliki, kata orang yang tidak pernah dicintai. \n\n - Raditya Dika')," +
                "('46' , 'baper' , 'Rindu dikalikan jarak sama dengan aku. \n\n - Sujiwo Tejo')," +
                "('47' , 'baper' , 'Cinta adalah pengorbanan, tapi kalo pengorbanan mulu sih namanya penderitaan. \n\n - Cak Lontong')," +
                "('48' , 'sabar' , 'uNomi selalu sabar kok ;)')," +
                "('49' , 'motivasi' , 'Saya tidak berbicara dengan kata mungkin \n\n - Abdurahman Wahid ')," +
                "('50' , 'motivasi' , 'Persiapkan hari ini untuk keinginan hari esok \n\n - Aesop')," +
                "('51' , 'motivasi' , 'Inovasi adalah pergerakan yang sangat cepat \n\n - Bill Gates')," +
                "('52' , 'motivasi' , 'Yang membuatku terus berkembang adalah tujuan-tujuan hidupku \n\n - Muhammad Ali')," +
                "('53' , 'motivasi' , 'Anda harus melalui hari ini dengan irama. Biarkan seluruh kehidupanmu berirama seperti lagu \n\n - Sai Baba')," +
                "('54' , 'motivasi' , 'Hidup itu sangat sederhana, tapi kita yang membuat hidup menjadi rumit \n\n - Confucius')," +
                "('55' , 'motivasi' , 'Sekali anda mengerjakan sesuatu, jangan takut gagal dan jangan tinggalkan itu. Orang-orang yang bekerja dengan ketulusan hati adalah mereka yang paling bahagia. \n\n - Chanakya')," +
                "('56' , 'motivasi' , 'Kesempatan untuk menemukan kekuatan yang lebih baik dalam diri kita muncul ketika hidup terlihat sangat menantang \n\n - Joseph Campbell')," +
                "('57' , 'motivasi' , 'Meningkatkan pada dasarnya merubah. Menjadi sempurna adalah perubahan yang dilakukan berulang \n\n - Winston Churchill')," +
                "('58' , 'motivasi' , 'Orang sukses akan mengambil keuntungan dari kesalahan dan mencoba lagi dengan cara yang berbeda \n\n - Dale Carnegie')," +
                "('59' , 'motivasi' , 'Satu-satunya sumber pengetahuan adalah pengalaman \n\n - Albert Einstein')," +
                "('60' , 'motivasi' , 'Aku tidak suka mengulangi kesuksesan yang ada, aku lebih suka untuk mencari hal lain \n\n - Walt Disney')," +
                "('61' , 'motivasi' , 'Hargailah usahamu, hargailah dirimu. Harga diri memunculkan disiplin diri. Ketika anda memiliki keduanya, itulah kekuatan sesungguhnya \n\n - Clint Eastwood')," +
                "('62' , 'motivasi' , 'Jangan menunggu setrika panas baru anda menyetrika; Tapi, buatlah setrika itu panas dengan menyetrika \n\n - W.B. Yeats')," +
                "('62' , 'motivasi' , 'Ada sebuah cara untuk melakukan lebih baik – temukanlah! \n\n - Thomas A. Edison')," +
                "('63' , 'motivasi' , 'Usaha akan membuahkan hasil setelah seseorang tidak menyerah \n\n - Napoleon Hill')," +
                "('64' , 'motivasi' , 'Kecemerlangan adalah melakukan hal yang biasa dengan cara yang sangat luar biasa \n\n - John W. Gardner')," +
                "('65' , 'motivasi' , 'Anda tidak akan bisa membangun sebuah reputasi dari apa yang akan anda lakukan  \n\n - Henry Ford')," +
                "('66' , 'motivasi' , 'Pertama, mereka mengabaikan anda. Kemudian, mereka tertawa pada anda. Berikutnya, mereka melawan anda. Lalu, anda menang  \n\n - Mahatma Gandhi')," +
                "('67' , 'motivasi' , 'Kesenangan dalam sebuah pekerjaan membuat kesempurnaan pada hasil yang dicapai \n\n - Aristoteles')," +
                "('68' , 'motivasi' , 'Mulailah setiap hari dengan senyuman dan akhiri dengan senyuman \n\n - W. C. Field')," +
                "('69' , 'motivasi' , 'Anda mungkin bisa menunda, tapi waktu tidak akan menunggu \n\n - Benjamin Franklin')," +
                "('70' , 'motivasi' , 'Percaya bahwa hidup itu pantas dijalani dan kepercayaan anda akan membantu anda membuat kenyataan hidup anda \n\n - William James')," +
                "('71' , 'motivasi' , 'Pamer adalah ide yang bodoh untuk sebuah kemenangan \n\n - Bruce Lee')," +
                "('72' , 'motivasi' , 'Saya tidak pernah takut untuk gagal \n\n - Michael Jordan')," +
                "('73' , 'motivasi' , 'Usaha dan keberanian tidak cukup tanpa tujuan dan arah perencanaan \n\n - John F. Kennedy')," +
                "('74' , 'motivasi' , 'Anda tidak bisa pergi dari tanggungjawab esok hari dengan menghindarinya hari ini \n\n - Abraham Lincoln')," +
                "('75' , 'unomi' , 'Iya? ada apa?')," +
                "('76' , 'lagi apa?' , 'Lagi mikirin kamu ^_^ ')," +
                "('77' , 'udah makan?' , 'uNomi ga perlu makan kok')," +
                "('78' , 'unomi' , 'iya? ada apa?'), "+
                "('79' , 'hi' , 'hi juga :D'), "+
                "('80' , 'hallo' , 'Hallo ^v^'), "+
                "('81' , 'cih' , 'kok jutek sih -,-'), "+
                "('82' , 'gi apa?' , 'Lagi ngapa yak? :D '), "+
                "('83' , 'oi' , 'Iya, kenapa?'), "+
                "('84' , 'hmm' , 'Kenapa to? ada apa?'), "+
                "('85' , 'hmm' , 'Bingung kenapa?'), "+
                "('86' , 'gabut' , 'Ealaa, sini uNomi hibur ^-^ '), "+
                "('87' , 'galo' , 'Galo kenapa?'), "+
                "('88' , 'mikirin dia' , 'Aduduh, udah mulai cinta - cinta an nihh .-. '), "+
                "('89' , 'mikirin dia' , 'Jangan dipikirin, pikirin uNomi aja  '), "+
                "('90' , 'mu' , 'Setan Merah? Manchester United?'), "+
                "('91' , 'musik' , 'Mau di nyanyiin apa? :) ')";





                db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE tbl_question");
        onCreate(db);
    }

}
