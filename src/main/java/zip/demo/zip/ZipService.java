package zip.demo.zip;

import zip.demo.user.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ZipService {
    @Autowired
    private ZipRepository zipRepository;

    @Transactional
    public void addZip(String pathZip, String user, byte[] file) {
        ZipArchive zipArchive = new ZipArchive(pathZip, user, file);
        zipRepository.save(zipArchive);
    }

    @Transactional(readOnly = true)
    public List<ZipArchive> findZipByLogin(String login) {
        return zipRepository.findZipByLogin(login);
    }

    @Transactional(readOnly = true)
    public byte[] findFileByZip(String pathZip) {
        return zipRepository.findOriginFile(pathZip);
    };

}
