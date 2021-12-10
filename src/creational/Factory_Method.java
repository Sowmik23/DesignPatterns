package creational;

interface ImageReader {
    DecodedImage getDecodedImage();
}

class DecodedImage {
    private String image;
    public DecodedImage(String image){
        this.image = image;
    }

    public String toString(){
        return image+": is decoded";
    }
}

class GifReader implements ImageReader {

    private DecodedImage decodedImage;

    public GifReader(String image){
        this.decodedImage = new DecodedImage(image);
    }
    @Override
    public DecodedImage getDecodedImage() {
        return decodedImage;
    }
}

class JpegReader implements ImageReader {

    private DecodedImage decodedImage;

    public JpegReader(String image){
        this.decodedImage = new DecodedImage(image);
    }
    @Override
    public DecodedImage getDecodedImage() {
        return decodedImage;
    }
}


public class Factory_Method {
    public static void main(String[] args){
        DecodedImage decodedImage;
        ImageReader imageReader = null;

        String image = args[0];
        String format = image.substring(image.indexOf('.')+1, image.length());

        if (format.equals("gif")){
            imageReader = new GifReader(image);
        }
        if (format.equals("jpeg")){
            imageReader = new JpegReader(image);
        }

        assert imageReader!=null;
        decodedImage = imageReader.getDecodedImage();
        System.out.println(decodedImage);
    }
}
