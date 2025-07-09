package ra.session_02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.session_02.entity.Showtime;
import ra.session_02.service.MovieService;
import ra.session_02.service.ScreenRoomService;
import ra.session_02.service.ShowtimeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public String listShowtimes(
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) Long screenRoomId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model
    ) {
        List<Showtime> showtimes = showtimeService.findByFilters(movieId, screenRoomId, date);

        model.addAttribute("showtimes", showtimes);
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("screenRooms", screenRoomService.findAll());

        model.addAttribute("selectedMovieId", movieId);
        model.addAttribute("selectedScreenRoomId", screenRoomId);
        model.addAttribute("selectedDate", date);

        return "showtime_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("showtime", new Showtime());
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("screenRooms", screenRoomService.findAll());
        return "showtime_add";
    }

    @PostMapping("/add")
    public String addShowtime(@ModelAttribute("showtime") Showtime showtime) {
        showtimeService.save(showtime);
        return "redirect:/showtimes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Showtime> optional = showtimeService.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("showtime", optional.get());
            model.addAttribute("movies", movieService.findAll());
            model.addAttribute("screenRooms", screenRoomService.findAll());
            return "showtime_edit";
        }
        return "redirect:/showtimes";
    }

    @PostMapping("/edit/{id}")
    public String updateShowtime(@PathVariable Long id, @ModelAttribute("showtime") Showtime showtime) {
        showtime.setId(id);
        showtimeService.update(showtime);
        return "redirect:/showtimes";
    }

    @PostMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeService.delete(id);
        return "redirect:/showtimes";
    }
}