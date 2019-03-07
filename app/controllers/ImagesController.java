package controllers;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ImageStore;

import java.io.File;
import java.nio.file.Path;

public class ImagesController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(ImagesController.class);

    private ImageStore imageStore;

    @Inject
    public ImagesController(ImageStore imageStore) {
        this.imageStore = imageStore;
    }

    public Result uploadImage() {

        final Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        if (null == body) {
            return badRequest("Not multipart request");
        }

        final Http.MultipartFormData.FilePart<File> image = body.getFile("file");
        if (null == image) {
            return badRequest("No file found");
        }

        if (!image.getContentType().equals("image/png")) {
            return badRequest("only PNG format supported");
        }

        final Path source = image.getFile().toPath();

        String imageId = imageStore.save(source);
        LOGGER.debug("image id {}", imageId);

        final String downloadUrl = routes.ImagesController.downloadImage(imageId).absoluteURL(request());

        final ObjectNode result = Json.newObject();
        result.put("image_url", downloadUrl);
        //result.put("imageId", imageId);

        return ok(result);
    }

    public Result downloadImage(String id) {

        final File file = imageStore.getImageById(id);
        if (null == file) {
            return notFound("Image not found");
        }

        return ok(file);
    }

    public Result deleteImage(String id) {

        final boolean deleted = imageStore.deleteImageById(id);
        if (!deleted) {
            return notFound("Image not found");
        }

        return ok();
    }

}