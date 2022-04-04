package com.fis.project.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.project.entity.Detective;
import com.fis.project.exception.AppException;
import com.fis.project.repo.DetectiveRepo;
import com.fis.project.service.imp.DetectiveServiceImp;

@SpringBootTest
public class DetectiveServiceImpTest {
	@Mock
	private DetectiveRepo detectiveRepo;
	
	@InjectMocks
	private DetectiveServiceImp detectiveServiceImp;
	
	@Test
	public void testCreate(){
		Detective detective = new Detective();
		detective.setId(1L);
		when(detectiveRepo.save(detective)).thenReturn(detective);
		Detective createDetective = detectiveServiceImp.createDetective(detective);
		assertThat(detectiveRepo.save(detective).equals(createDetective));
	}
	
	@Test
	public void testFindByid() {
		Detective detective = new Detective();
		detective.setId(1L);
		Optional<Detective> optional = Optional.of(detective);
		when(detectiveRepo.findById(1L)).thenReturn(optional);
		when(detectiveRepo.findById(2L)).thenThrow(new AppException("301", "Detective Id not Found!"));
		assertThrows(AppException.class, ()-> detectiveServiceImp.findById(2L));
		assertThat(detectiveServiceImp.findById(1L).equals(detective));
	}
	
	@Test
	public void testDeleteById() {
		Detective detective= new Detective();
		detective.setId(1L);
		detectiveServiceImp.deleteById(1L);
		verify(detectiveRepo,times(1)).deleteById(1L);
	}
}
