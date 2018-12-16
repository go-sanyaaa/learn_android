package info.goodline.department.learnandroid.image;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import info.goodline.department.learnandroid.R;

public class ImagePickActivity extends AppCompatActivity {

    //Объявляем используемые переменные:
    private ImageView ivPhoto;
    private final int REQUEST_CODE_PICK_IMAGE_GALLARY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pick);

        //Связываемся с нашим ImageView:
        ivPhoto = findViewById(R.id.ivPhoto);

        // Вешаем на кнопку обработчик нажатий
        findViewById(R.id.btnChooseImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Интент для получения всех приложений которые могут отображать изображения
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                // Вызываем системное диалоговое окно для выбора приложения, которое умеет отображать изображения
                // и возвращать выбранную фотографию
                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Выберите изображение");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                // Запускаем приложения и ожидаем результат
                startActivityForResult(chooserIntent, REQUEST_CODE_PICK_IMAGE_GALLARY);
            }
        });
    }

    //Обрабатываем результат выбора в галерее:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case REQUEST_CODE_PICK_IMAGE_GALLARY:
                if (resultCode == RESULT_OK) {
                    try {
                        //Получаем URI изображения, преобразуем его в Bitmap
                        //объект и отображаем в элементе ImageView нашего интерфейса:
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        ivPhoto.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        // Эта ошибка отобразится в случае если не удалось найти изображение
                        e.printStackTrace();
                    }
                }
        }
    }
}
