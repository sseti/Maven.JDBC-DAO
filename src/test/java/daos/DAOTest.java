package daos;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;



public class DAOTest {

    DAO car = new DAO();
    DTO carDTO = new DTO(4567, "Acura", "TL",2002,"White",545247894);
    DTO carDTO1 = new DTO(9867, "Acura", "RL",2007,"Gold",434343423);

    @Test
    public void extractCarFromResultSetTest() {
        DTO newCar = car.findById(1234);
        Assert.assertEquals(newCar.getId(), newCar.getId());
    }
    @Test
    public void findById() {
        car.create(carDTO1);
        DTO newCar = car.findById(9867);
        Assert.assertEquals("Acura", newCar.getMake());
        Assert.assertEquals("RL", newCar.getModel());
        Assert.assertEquals(2007, newCar.getYear());
        Assert.assertEquals("Gold", newCar.getColor());
        Assert.assertEquals(434343423, newCar.getVin());
        car.delete(9867);

    }

    @Test
    public void findAll() {
        List<DTO> list = car.findAll();
        Integer expectedSize = 5;
        Integer actualSize = list.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void update() {
        car.create(carDTO);
        DTO expected = new DTO(4567, "Acura", "TL",2002,"White",545247894);
        car.update(expected);
        DTO actual = car.findById(4567);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getMake(), actual.getMake());
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getYear(), actual.getYear());
        assertEquals(expected.getColor(), actual.getColor());
        assertEquals(expected.getVin(), actual.getVin());
        car.delete(4567);
    }

    @Test
    public void create() {
        assertTrue(car.create(carDTO));
        car.delete(4567);
    }

    @Test
    public void delete() {
        car.create(carDTO);
        assertEquals(4567, carDTO.getId());
        car.delete(4567);
        assertNull(car.findById(4567));
    }
}