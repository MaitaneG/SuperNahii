using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Models

{
    /// <summary>
    /// Puntuazioa egiteko modeloa
    /// </summary>
    public class PuntuazioaModel
    {
        public int Id { get; set; }
        public string Jokalari { get; set; }
        public int Puntuazioa { get; set; }
        public DateTime Data { get; set; }
    }
}
