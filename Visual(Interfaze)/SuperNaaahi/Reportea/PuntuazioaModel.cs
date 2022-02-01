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
        /// <summary>
        /// Id primary key
        /// </summary>
        public int Id { get; set; }
        /// <summary>
        /// Jokalariaren izena
        /// </summary>
        public string Jokalari { get; set; }
        /// <summary>
        /// Egin dituen puntuak
        /// </summary>
        public int Puntuazioa { get; set; }
        /// <summary>
        /// Noiz data eta ordua
        /// </summary>
        public DateTime Data { get; set; }
    }
}
