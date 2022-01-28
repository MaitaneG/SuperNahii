using Newtonsoft.Json;
using SuperNaaahi.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    /// <summary>
    /// Puntuazioaren informazioa Rest-apitik kudeatzeko
    /// </summary>
    public class PuntuazioaService: IPuntuazioaService
    {
        private Uri rutaTodos = new Uri("http://192.168.65.7:8080/puntuazioak/");

        /// <summary>
        /// Rest-apitik puntuazioa jaso
        /// </summary>
        /// <returns> Puntuazioen lista itzuli</returns>
        public async Task<List<PuntuazioaModel>> GetPuntuazioak()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
               using (var response = await httpClient.GetAsync(rutaTodos)) 
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }

        /// <summary>
        /// Rest-apitik puntuazio onenak jaso
        /// </summary>
        /// <returns>Puntuazio onenan lista itzuli</returns>
        public async Task<List<PuntuazioaModel>> GetHallOfFame()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos+"hallOfFame/"))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }

        /// <summary>
        /// Rest-apitik puntuazio txarrenak jaso
        /// </summary>
        /// <returns>Puntuazio txarrenan lista itzuli</returns>
        public async Task<List<PuntuazioaModel>> GetHallOfShame()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos + "hallOfShame/"))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }
        /// <summary>
        /// Rest-apitik 5 puntuazio jaso
        /// </summary>
        /// <returns>5 puntuazio dauden lista itzuli</returns>
        public async Task<List<PuntuazioaModel>> GetBostPuntuazio()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos + "bostPuntuazio/"))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }
        /// <summary>
        /// Rest-apitik 10 puntuazio jaso
        /// </summary>
        /// <returns>10 puntuazio dauden lista itzuli</returns>
        public async Task<List<PuntuazioaModel>> GetHamarPuntuazio()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos + "hamarPuntuazio/"))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }
        /// <summary>
        /// Rest-apitik 15 puntuazio jaso
        /// </summary>
        /// <returns>15 puntuazio dauden lista itzuli</returns>
        public async Task<List<PuntuazioaModel>> GetHamabostPuntuazio()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos + "hamabostPuntuazio/"))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }





    }
}
