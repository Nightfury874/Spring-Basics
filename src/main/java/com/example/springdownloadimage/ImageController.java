package com.example.springdownloadimage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@Controller
@RequestMapping("/image")
public class ImageController {

    @GetMapping("/download")
    @ResponseBody
    public String downloadImage() {
        String imageUrl = "https://api.dominos.co.in/prod-olo-api/images/Home_Paytm_20210519.jpg";
        String savePath = "/Users/niharbasisth/Desktop/Landing/img.jpg";
        try {
            URL url = new URL(imageUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(savePath);
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();

            return "Image saved at: " + savePath;

        } catch (IOException e) {
            e.printStackTrace();
            return "Image download failed.";
        }
    }

    @GetMapping("/page")
    public String showImageDownloadPage(Model model) {
        return "image-download";
    }
}
