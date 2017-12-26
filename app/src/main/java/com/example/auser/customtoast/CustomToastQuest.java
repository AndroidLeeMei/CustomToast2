package com.example.auser.customtoast;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.KeyEvent;
        import android.view.View;
        import android.view.View.OnKeyListener;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.Toast;

public class CustomToastQuest extends Activity {

    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findView();
        setOnKeyListener();
    }

    void findView(){
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
    }

    void setOnKeyListener(){
        et1.setOnKeyListener(onKeyListener);
        et2.setOnKeyListener(onKeyListener);
        et3.setOnKeyListener(onKeyListener);
    }

    OnKeyListener onKeyListener = new OnKeyListener(){

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event)
        {
            //判斷使用者是否有按下的動作以及按下的是否為Enter鍵
            if(event.getAction()==KeyEvent.ACTION_DOWN & keyCode == KeyEvent.KEYCODE_ENTER){

                System.out.println("===="  + ((EditText)v).getText().toString());
                System.out.println("==equals(null)=="  + ((EditText)v).getText().toString().equals(null));
                System.out.println("==.equals(\"\")=="  + !(((EditText)v).getText().toString().equals("")));
                System.out.println("=length==="  + (((EditText)v).getText().length()>0));
                if(((EditText)v)==et3) {

                    //取得使用者輸入的選項，並轉成數值，以便於switch-case的比對
                    if (((EditText)v).getText().length()>0){
                    int choice = Integer.parseInt(((EditText) v).getText().toString());

                    //當使用者互動的是EditText3時，根據使用者的選擇，來顯示特定文字
                    switch (choice) {
                        case 1:
                            customToast2All(R.string.number1,R.drawable.crispy);
                            break;
                        case 2:
                            customToast2All(R.string.number2,R.drawable.big_mac);
                            break;
                        case 3:
                            customToast2All(R.string.number3,R.drawable.spicy_chicken_filet_burger);
                            break;
                        case 4:
                            customToast2All(R.string.number4,R.drawable.chicken_mc_nuggets_4pcs);
                            break;

//                        case 2:Toast.makeText(CustomToastQuest.this, R.string.number2, Toast.LENGTH_SHORT).show(); break;
//                        case 3:Toast.makeText(CustomToastQuest.this, R.string.number3, Toast.LENGTH_SHORT).show(); break;
//                        case 4:Toast.makeText(CustomToastQuest.this, R.string.number4, Toast.LENGTH_SHORT).show(); break;
//                        default:Toast.makeText(CustomToastQuest.this, R.string.wrong, Toast.LENGTH_SHORT).show();
                    }
                }
                }
                else
                    //當使用者互動的是EditText1與EditText2時，就顯示使用者所輸入的資料
                    Toast.makeText(CustomToastQuest.this, ((EditText)v).getText().toString(), Toast.LENGTH_SHORT).show();
            }
            // TODO Auto-generated method stub
            return false;
        }
    };

    void customToast(){
        Toast toast=Toast.makeText(CustomToastQuest.this, R.string.number1, Toast.LENGTH_SHORT);
        View original=toast.getView();
        LinearLayout linearLayout=new LinearLayout(CustomToastQuest.this);//改用程式動態建立,所不用findviewbyid
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ImageView img=new ImageView(CustomToastQuest.this);
        img.setImageResource(R.drawable.crispy);
        linearLayout.addView(img);
        linearLayout.addView(original);
        toast.setView(linearLayout);
        toast.show();
    }


    void customToast2All(int intNum,int intImg){
        Toast toast=Toast.makeText(CustomToastQuest.this, intNum, Toast.LENGTH_SHORT);
        View original=toast.getView();
        LinearLayout linearLayout=new LinearLayout(CustomToastQuest.this);//改用程式動態建立,所不用findviewbyid
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ImageView img=new ImageView(CustomToastQuest.this);
        img.setImageResource(intImg);
        linearLayout.addView(img);
        linearLayout.addView(original);
        toast.setView(linearLayout);
        toast.show();
    }


    void customToastAll(int castInt){
        int intImg=0,intNum=0;
        switch (castInt){
            case 1:intImg=R.drawable.crispy;
                intNum=R.string.number1;
                break;
            case 2:intImg=R.drawable.big_mac;
                intNum=R.string.number2;
                break;
            case 3:intImg=R.drawable.spicy_chicken_filet_burger;
                intNum=R.string.number3;
                break;
            case 4:intImg=R.drawable.chicken_mc_nuggets_4pcs;
                intNum=R.string.number4;
                break;
        }

        Toast toast=Toast.makeText(CustomToastQuest.this, intNum, Toast.LENGTH_SHORT);
        View original=toast.getView();
        LinearLayout linearLayout=new LinearLayout(CustomToastQuest.this);//改用程式動態建立,所不用findviewbyid
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ImageView img=new ImageView(CustomToastQuest.this);

        img.setImageResource(intImg);




        linearLayout.addView(img);
        linearLayout.addView(original);
        toast.setView(linearLayout);
        toast.show();
    }
}
