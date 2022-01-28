using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Models
{
    /// <summary>
    /// Foroa egiteko modeloa
    /// </summary>
    public class Foroa
    {
        /// <summary>
        /// Id: priamry key eta  [ScaffoldColumn(false)] id eremua ez dugu hartuko
        /// </summary>
        [Key]
        [ScaffoldColumn(false)]
        public int Id{ get; set; }
        /// <summary>
        /// Korreoa derrigorrez sartu eta formatu egokiarekin
        /// </summary>
        [Required(ErrorMessage = "Zure korreoa derrigorrez sartu behar duzu.")] 
        [RegularExpression("^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", ErrorMessage = "Korreoaren formatua gaizki dago.")]
        public string Korreoa { get; set; }
        /// <summary>
        /// Komentarioa derrigorrez sartu
        /// </summary>
        [Required(ErrorMessage = "Derrigorrez zerbait komentatu behar duzu.")]
        public string Komentarioa { get; set; }
        /// <summary>
        /// [ScaffoldColumn(false)] data eramua ez dugu hartuko
        /// </summary>
        [ScaffoldColumn(false)]
        public System.DateTime Data { get; set; }
    }
}
