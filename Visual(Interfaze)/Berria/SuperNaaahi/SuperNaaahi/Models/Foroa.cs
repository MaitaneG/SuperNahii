using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Models
{
    /**
     * Foroa egiteko modeloa
     */
    public class Foroa
    {
        [Key]
        [ScaffoldColumn(false)]
        public int Id{ get; set; }
        [Required(ErrorMessage = "Zure korreoa derrigorrez sartu behar duzu.")] // Korreoa derrigorrezkoa izateko
        [RegularExpression("^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", ErrorMessage = "Korreoaren formatua gaizki dago.")] // Korreoaren formatua konprobatzeko
        public string Korreoa { get; set; }
        [Required(ErrorMessage = "Derrigorrez zerbait komentatu behar duzu.")]
        public string Komentarioa { get; set; }
        [ScaffoldColumn(false)]
        public System.DateTime Data { get; set; }
    }
}
