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
    private static final int    DATABASE_VERSION = 1;



    public DBuNomi(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE tbl_question (id INTEGER PRIMARY KEY, question text null, answer text null)";
        db.execSQL(query);

        query = "INSERT INTO tbl_question(id,question,answer) VALUES " +
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
                "('25' , 'mati', 'Hargai hidupmu, berjuang, bersyukur dan teruslah hidup')";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
