package com.whfp.oa.commons.gt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/****
 * 
 * 添加水印
 * 
 * @author Administrator
 * 
 */
public class ImageUtil {
	public static void ImgYin(String s, String ImgName) {
		try {
			File _file = new File(ImgName);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			g.setColor(Color.RED);
			g.setFont(new Font("宋体", Font.PLAIN, 50));
			Font aa = new Font("宋体", Font.PLAIN, 50);
			g.drawString(s, 0, 0);
			g.dispose();
			FileOutputStream out = new FileOutputStream(ImgName);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		ImageUtil ib = new ImageUtil();
		ImageUtil
				.ImgYin("我是水印",
						"C:\\Users\\think\\Desktop\\26c83ec087514d06a42b30e19367d19d.jpg");
	}
}