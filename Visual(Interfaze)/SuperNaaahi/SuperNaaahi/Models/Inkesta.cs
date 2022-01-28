using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Models
{
    /// <summary>
    /// Inkesta egiteko modeloa
    /// </summary>
    public class Inkesta
    {
        /// <summary>
        /// Korreoa derrigorrezkoa, formato egokiarekin eta primary key
        /// </summary>
        [Key]
        [Required(ErrorMessage ="Zure korreoa derrigorrez sartu behar duzu.")] // Korreoa derrigorrezkoa izateko
        [RegularExpression("^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", ErrorMessage = "Korreoaren formatua gaizki dago.")] // Korreoaren formatua konprobatzeko
        public string Korreoa { get; set; }
        /// <summary>
        /// Balorazioa derrigorrez ebte 1-10
        /// </summary>
        [Required(ErrorMessage = "Balorazioa derrigorrez sartu behar duzu.")] // Balorazioa derrigorrezkoa izateko
        public int Balorazioa { get; set; }
        /// <summary>
        /// Hobetzeko komentarioa
        /// </summary>
        public string Hobetzeko { get; set; }
        /// <summary>
        /// Bai ala ez gomendatu
        /// </summary>
        public bool Gomendatu { get; set; }
    }
}
