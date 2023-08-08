package ma.sir.ged.ws.facade.open;

import io.minio.errors.*;
import ma.sir.ged.service.facade.open.MinIOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


//1- download minio from :::: https://min.io/docs/minio/windows/index.html
//2- run the command (on the exe file) : .\minio.exe server C:\minio --console-address :9090
//3- change minio.accessKey=Vh4IZZ6xwTg781Upj1qp and minio.secretKey=nScFlyHHJGdnosTi5FOsFOyDsVBGJp7TmxNmFp5B
// in app-dev.prop to new value defined in http://192.168.0.100:9090/access-keys

@RestController
@RequestMapping("/api/open/minio")
public class MinioController {

    @Autowired
    private MinIOService minIOService;

    //--- Check if bucket exists or not ---
    //curl "http://localhost:8036/minio/bucket/my-bucket"
    @GetMapping("/bucket/{name}")
    public int bucketExists(@PathVariable String name) {
        return minIOService.bucketExists(name);
    }

    //--- Upload a file to the bucket ---
    //curl -X POST -F "file=@./file01.pdf" http://localhost:8036/minio/upload/file/my-bucket
    @PostMapping("/upload/file/{bucket}")
    public int upload(@RequestParam("file") MultipartFile file, @PathVariable String bucket) {
        return minIOService.upload(file, bucket);
    }

    //--- Create a new bucket ---
    //curl -X POST -F "bucketName=my-new-bucket" http://localhost:8036/minio/bucket
    @PostMapping("/bucket")
    public int saveBucket(@RequestParam("bucketName") String bucket) {
        return minIOService.saveBucket(bucket);
    }

    //--- List all files of a bucket ---
    //curl -X GET http://localhost:8036/minio/findAll/bucket/my-bucket
    @GetMapping("/findAll/bucket/{bucket}")
    public List<String> findAllDocuments(@PathVariable String bucket) {
        return minIOService.findAllDocuments(bucket);
    }

    //--- Download all files from a bucket ---
    //curl -o D:/GED/all_documents.zip http://localhost:8036/minio/downloadAll/bucket/my-bucket
    @GetMapping("/downloadAll/bucket/{bucket}")
    public byte[] downloadAllDocumentsAsZip(@PathVariable String bucket) {
        return minIOService.downloadAllDocumentsAsZip(bucket);
    }

    //  curl -o D:/GED/documents.zip http://localhost:8036/minio/download/files/bucket/bucket03/?files=file01.pdf,culture.pptx
    @GetMapping("/download/files/bucket/{bucket}")
    public byte[] downloadDocumentsAsZip(@PathVariable String bucket, @RequestParam("files") List<String> filenames) {
        return minIOService.downloadDocumentsAsZip(bucket, filenames);
    }

    //  curl -X POST -F "directoryPath=D:/GED/Figma" http://localhost:8036/minio/folder/bucket/bucket03
    @PostMapping("/folder/bucket/{bucket}")
    public void uploadDirectory(@RequestParam("directoryPath") String directoryPath, @PathVariable String bucket) throws IOException, NoSuchAlgorithmException, InvalidKeyException, MinioException {
        minIOService.uploadDirectory(directoryPath, bucket);
    }

    //  curl -X POST "http://localhost:8036/minio/delete/bucket/bucket03/file/file03.pdf"
    @PostMapping("/delete/bucket/{bucket}/file/{file}")
    public int deleteFileFromBucket(@PathVariable String file, @PathVariable String bucket) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return minIOService.deleteFileFromBucket(file, bucket);
    }

    //  curl -X POST "http://localhost:8036/api/open/minio/save/folder/bucket/ged/folder/testFolder"
    @PostMapping("/save/folder/bucket/{bucket}/folder/{folder}")
    public int createFolderInBucket(@PathVariable String folder, @PathVariable String bucket) {
        return minIOService.createFolderInBucket(folder, bucket);
    }

    //  curl -X GET "http://localhost:8036/api/open/minio/exists/folder/testFolder/bucket/ged"
    @GetMapping("/exists/folder/{folder}/bucket/{bucket}")
    public boolean checkFolderExistsInBucket(@PathVariable String folder, @PathVariable String bucket) {
        return minIOService.checkFolderExistsInBucket(folder, bucket);
    }
}
