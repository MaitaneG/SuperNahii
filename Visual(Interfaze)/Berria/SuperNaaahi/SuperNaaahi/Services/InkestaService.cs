using SuperNaaahi.Data;
using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public class InkestaService : IInkestaService
    {
        private readonly SuperNaaahiDbContext _superNaaahiDbContext;

        public InkestaService(SuperNaaahiDbContext superNaaahiDbContext)
        {
            _superNaaahiDbContext = superNaaahiDbContext;
        }

        public async Task InkestaBete(Inkesta i)
        {
            try
            {
                Inkesta inkesta = new Inkesta();
                inkesta = _superNaaahiDbContext.Inkesta.SingleOrDefault(
                    i => i.Korreoa!=null);

                if (inkesta == null)
                {
                    inkesta = i;
                    _superNaaahiDbContext.Inkesta.Add(inkesta);
                    _superNaaahiDbContext.SaveChanges();
                }
                else
                {
                   
                }
            }

            catch(Exception ex)
            {

            }
        }
    }
}
