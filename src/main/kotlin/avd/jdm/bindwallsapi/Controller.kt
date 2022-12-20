package avd.jdm.bindwallsapi

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class Controller(
    private val repository: Repository
) {

    @GetMapping("/blindwalls")
    fun getAll(): BlindWallsCollection {
        val allBlindWalls = repository.findAll()
        println("get allBlindWalls ${allBlindWalls.size}")

        return BlindWallsCollection(blindwalls = allBlindWalls)
    }

    @GetMapping("/blindwalls/{id}")
    fun getById(
        @PathVariable id: Int
    ): Optional<BlindWall> = repository.findById(id)

    @PutMapping("/blindwalls/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody blindWall: BlindWall
    ): BlindWall {
        require(blindWall.id == id)
        return repository.saveAndFlush(blindWall)
    }

    @PostMapping("/blindwalls")
    fun create(
        @RequestBody todoItem: BlindWall
    ): BlindWall {
        require(todoItem.id == null)
        return repository.saveAndFlush(todoItem)
    }

    @DeleteMapping("/blindwalls/{id}")
    fun delete(@PathVariable id: Int) = repository.deleteById(id)
}